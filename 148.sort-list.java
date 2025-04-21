/*
 * @lc app=leetcode.cn id=148 lang=java
 * @lcpr version=30204
 *
 * [148] 排序链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // 递归终止条件：链表为空或只有一个节点，已经有序
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 找到链表中间节点的前一个节点，并分割链表
        ListNode midPrev = findMiddlePrev(head);
        ListNode rightHead = midPrev.next; // 后半部分的头节点
        midPrev.next = null; // 断开链表

        // 2. 递归排序左右两部分
        ListNode leftSorted = sortList(head);      // 前半部分 head 到 midPrev
        ListNode rightSorted = sortList(rightHead); // 后半部分 rightHead 到末尾

        // 3. 合并两个有序链表
        return mergeTwoLists(leftSorted, rightSorted);
    }

    /**
     * 快慢指针找到链表中间节点的前一个节点。
     * 对于 [1,2,3,4], 返回 2。
     * 对于 [1,2,3,4,5], 返回 2。
     * 这样可以保证分割后左半部分长度 <= 右半部分长度。
     */
    private ListNode findMiddlePrev(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 或 null，取决于调用者如何处理，这里返回 head 避免空指针
        }
        ListNode slow = head;
        // fast 初始化为 head.next.next，这样 slow 最终会停在中间节点的前一个
        // 或者 fast 初始化为 head，循环条件改为 fast.next != null && fast.next.next != null
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 合并两个有序链表
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个哨兵节点，简化合并逻辑
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy; // current 指针用于构建新链表

        // 遍历两个链表，比较节点值，将较小的节点连接到 current 后面
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) { // 注意使用 <= 保持稳定性（可选）
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // 移动 current 指针
        }

        // 循环结束后，最多还有一个链表有剩余节点，将其连接到新链表末尾
        if (list1 != null) {
            current.next = list1;
        } else { // list2 != null or list2 == null
            current.next = list2;
        }

        // 返回哨兵节点的下一个节点，即合并后链表的头节点
        return dummy.next;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,5,3,4,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */

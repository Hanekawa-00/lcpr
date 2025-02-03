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
        if (head == null || head.next == null) {
            return head;
        }
        // 类似二分查找
        ListNode head2 = getMiddleNode(head);
        // 递归排序
        head = sortList(head);
        head2 = sortList(head2);
        // 最终递归到只有两个节点，这样排序成为一个新的链表返回到上一层递归，以达到排序链表
        return mergeTwoLists(head2, head);
    }

    /**
     * 使用快慢指针获取链表中间节点
     * 
     * @param head
     * @return
     */
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 这里其实是中间节点的下一个节点
        ListNode mid = slow.next;
        // 断开与前面的连接
        slow.next = null;
        return mid;
    }

    /**
     * 合并两个有序链表
     * 
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        // 如果其中有一个遍历完成，则直接拼接另一个链表即可
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;
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

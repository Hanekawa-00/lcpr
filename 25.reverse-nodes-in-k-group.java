/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        // 创建头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 前置节点
        ListNode prev = dummy;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        // 此时curr指向最后一个节点
        while (count >= k) {
            curr = prev.next;
            // 此时curr指向head
            ListNode next = curr.next;
            // 反转链表
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            // 更新
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }

    // 反转链表
    // ate ListNode reverseList(ListNode head) {
    // ListNode prev = null;
    // ListNode curr = head;

    // e (curr != null) {
    // ListNode next = curr.next; // 保存下一个节点
    // curr.next = prev; // 反转当前节点指针
    // prev = curr; // 移动prev指针
    // curr = next; // 移动curr指针
    // }
    // return prev;
    // }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n3\n
 * // @lcpr case=end
 * 
 */

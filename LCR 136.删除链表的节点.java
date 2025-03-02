/*
 * @lc app=leetcode.cn id=LCR 136 lang=java
 * @lcpr version=30204
 *
 * [LCR 136] 删除链表的节点
 */

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
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            if (node.val == val) {
                ListNode next = node.next;
                node.next = null;
                pre.next = next;
                break;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,5,1,9]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,5,1,9]\n1\n
 * // @lcpr case=end
 * 
 */

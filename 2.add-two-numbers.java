/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30204
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int newVal;
            if (l1 != null && l2 != null) {
                newVal = l1.val + l2.val + carry;
            } else if (l1 == null) {
                newVal = l2.val + carry;
            } else {
                newVal = l1.val + carry;
            }
            carry = newVal / 10;
            newVal %= 10;
            ListNode newNode = new ListNode(newVal);
            if (head == null) {
                head = newNode;
                node = head;
            } else {
                node.next = newNode;
                node = node.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,4,3]\n[5,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n[0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [9,9,9,9,9,9,9]\n[9,9,9,9]\n
 * // @lcpr case=end
 * 
 */

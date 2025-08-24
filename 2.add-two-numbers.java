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
        ListNode carry = new ListNode(0);
        ListNode curr = new ListNode(-1);
        ListNode head = curr;
        while (l1 != null || l2 != null) {
            // 两个链表都为null说明遍历结束
            if (l1 == null && l2 == null) {
                break;
            }
            // 其中一个链表已经遍历结束，则视为0
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            } 
            int currVal = (l1.val + l2.val + carry.val) % 10;
            int carryVal = (l1.val + l2.val + carry.val) / 10;
            curr.next = new ListNode(currVal);
            carry.val = carryVal;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        // 进位可能还存在
        if (carry.val != 0) {
            curr.next = carry;
        }
        return head.next;
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

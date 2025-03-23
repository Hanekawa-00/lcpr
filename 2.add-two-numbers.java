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
        // 存储进位信息
        int carry = 0;
        ListNode head = new ListNode();
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int num1, num2;
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            int curr = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            node.val = curr;
            // 防止多出一个值为0的节点
            if (l1 != null || l2 != null) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        // 如果前面有进位则多出一位
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

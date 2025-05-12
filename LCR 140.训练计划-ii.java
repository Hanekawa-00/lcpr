/*
 * @lc app=leetcode.cn id=LCR 140 lang=java
 * @lcpr version=30204
 *
 * [LCR 140] 训练计划 II
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
    public ListNode trainingPlan(ListNode head, int cnt) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        for (int i = n; i > cnt; i--) {
            head = head.next;
        }
        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,4,7,8]\n1\n
 * // @lcpr case=end
 * 
 */

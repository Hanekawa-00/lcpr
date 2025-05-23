/*
 * @lc app=leetcode.cn id=LCR 142 lang=java
 * @lcpr version=30204
 *
 * [LCR 142] 训练计划 IV
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
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 取最小值作为头节点
        if (l1.val <= l2.val) {
            l1.next = trainningPlan(l1.next, l2);
        } else {
            l2.next = trainningPlan(l1, l2.next);
        }
        return l1.val <= l2.val ? l1 : l2;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,4]\n[1,3,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n[]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n[0]\n
 * // @lcpr case=end
 * 
 */

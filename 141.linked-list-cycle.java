/*
 * @lc app=leetcode.cn id=141 lang=java
 * @lcpr version=30204
 *
 * [141] 环形链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,0,-4]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n-1\n
 * // @lcpr case=end
 * 
 */

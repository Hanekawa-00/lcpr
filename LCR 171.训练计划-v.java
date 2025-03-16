/*
 * @lc app=leetcode.cn id=LCR 171 lang=java
 * @lcpr version=
 *
 * [LCR 171] 训练计划 V
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 双指针
        ListNode pA = headA, pB = headB;
        // 如果两个链表不相交，最终会在null处相遇
        while (pA != pB) {
            // 如果pA到达链表尾部，则从headB开始，以此类推，最终会在相交点相遇（规律）
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 8\n[4,1,8,4,5]\n[5,0,1,8,4,5]\n2\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[0,9,1,2,4]\n[3,2,4]\n3\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 0\n[2,6,4]\n[1,5]\n3\n2\n
 * // @lcpr case=end
 * 
 */

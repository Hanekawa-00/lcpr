/*
 * @lc app=leetcode.cn id=160 lang=java
 * @lcpr version=30204
 *
 * [160] 相交链表
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while (ptrA != ptrB) {
            // 两个指针走的步数是相同的，切换头部能够消除步数差
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        } // 结果是要么两个相遇，要么两个都为null
        return ptrA;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[1,9,1,2,4]\n[3,2,4]\n3\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 0\n[2,6,4]\n[1,5]\n3\n2\n
 * // @lcpr case=end
 * 
 */

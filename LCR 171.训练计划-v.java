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
        ListNode l1 = headA, l2 = headB;
        // 使用补偿法，两个指针走的步数是相同的，交换起点可以补偿链表长度差
        while (l1 != l2) {
            if (l1 == null) {
                l1 = headB;
            } else {
                l1 = l1.next;
            }
            if (l2 == null) {
                l2 = headA;
            } else {
                l2 = l2.next;
            }
        }
        return l1;
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

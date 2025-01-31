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
    /**
     * 可用快慢指针，在环中快指针肯定会和慢指针相遇，若fast能够走到头说明链表中没有环
     * 
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> cachedSet = new HashSet<ListNode>();
        while (head.next != null) {
            if (cachedSet.contains(head.next)) {
                return true;
            }
            cachedSet.add(head);
            head = head.next;
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

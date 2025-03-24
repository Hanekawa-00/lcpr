/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30204
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        // 快指针先走 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 如果 fast 为空（fast已经走完整个链表），则说明要删除的是头节点
        if (fast == null) {
            return head.next;
        }
        ListNode low = head;
        // 快慢指针同时走，直到 fast 到达链表末尾
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        // 删除 low.next，即倒数第 n 个节点
        ListNode target = low.next;
        low.next = target.next;
        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n1\n
 * // @lcpr case=end
 * 
 */

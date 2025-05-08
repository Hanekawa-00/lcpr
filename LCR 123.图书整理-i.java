/*
 * @lc app=leetcode.cn id=LCR 123 lang=java
 * @lcpr version=30204
 *
 * [LCR 123] 图书整理 I
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
    public int[] reverseBookList(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode pre = null;
        int count = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        int[] res = new int[count];
        for (int i = 0; i < res.length; i++) {
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,6,4,1]\n
 * // @lcpr case=end
 * 
 */

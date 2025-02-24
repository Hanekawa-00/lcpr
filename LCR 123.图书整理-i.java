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
        ListNode node = head;
        int count = 0;
        // 反转链表的同时统计节点数
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
            count++;
        }
        // 此时 pre 指向反转后链表的头
        int[] res = new int[count];
        node = pre; // 重置 node 指向反转后的链表头
        for (int i = 0; i < count; i++) {
            res[i] = node.val;
            node = node.next;
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

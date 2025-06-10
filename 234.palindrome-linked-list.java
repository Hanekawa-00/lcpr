/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30204
 *
 * [234] 回文链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.addLast(node.val);
            node = node.next;
        }
        while (!deque.isEmpty()) {
            int left = deque.removeFirst();
            // 只剩一个元素时
            if (deque.isEmpty()) {
                return true;
            }
            int right = deque.removeLast();
            if (left != right) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n
 * // @lcpr case=end
 * 
 */

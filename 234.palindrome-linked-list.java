/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30204
 *
 * [234] 回文链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;

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
        ArrayList<Integer> vars = new ArrayList<Integer>();
        ListNode curr = head;
        while (curr != null) {
            vars.add(curr.val);
            curr = curr.next;
        }
        int front = 0;
        int back = vars.size() - 1;
        while (front < back) {
            if (!vars.get(front).equals(vars.get(back))) {
                return false;
            }
            front++;
            back--;
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

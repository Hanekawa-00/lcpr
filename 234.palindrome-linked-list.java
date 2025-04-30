/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30204
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // 空链表或单个节点都是回文
        }

        // 1. 使用快慢指针找到链表中点（slow 指向前半部分最后一个节点）
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转后半部分链表（从 slow.next 开始）
        ListNode secondHalf = reverseList(slow.next);
        ListNode firstHalf = head;

        // 3. 同步比较前半和反转后的后半部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true; // 所有节点值相同，是回文链表
    }

    // 辅助函数：反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
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

/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        // 计算链表长度
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // K个一组反转
        while (count >= k) {
            curr = prev.next; // 当前组的第一个节点
            ListNode tail = curr; // 保存当前组反转后的尾节点
            ListNode next = curr.next; // 

            // 反转k-1次
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            // 更新指针
            prev = tail; // 移动到下一组的前置节点
            count -= k;
        }
        return dummy.next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n3\n
 * // @lcpr case=end
 * 
 */

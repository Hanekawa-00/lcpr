/*
 * @lc app=leetcode.cn id=LCR 136 lang=java
 * @lcpr version=30204
 *
 * [LCR 136] 删除链表的节点
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
    public ListNode deleteNode(ListNode head, int val) {
        ListNode target = null;
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                target = node;
                break;
            }
            pre = node; 
            node = node.next;
        }
        // 如果pre是null那么说明删除的是head节点
        if (pre == null) {
            return head.next;
        }
        // 删除节点操作
        ListNode next = target.next;
        pre.next = next;
        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,5,1,9]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,5,1,9]\n1\n
 * // @lcpr case=end
 * 
 */

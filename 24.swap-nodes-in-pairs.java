/*
 * @lc app=leetcode.cn id=24 lang=java
 * @lcpr version=30204
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        // 创建哑结点，防止第一个节点的特殊判断
        ListNode dummpyHead = new ListNode(-1);
        dummpyHead.next = head;
        ListNode curr = dummpyHead;
        // 目的是交换curr后面的两个节点,curr在这里相当于前置节点
        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = node1.next;
            // 获取这两个节点后面的那个节点
            ListNode nextNode = node2.next;
            // 交换
            node2.next = node1;
            node1.next = nextNode;
            curr.next = node2;
            // 更新
            curr = node1;
        }
        return dummpyHead.next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */

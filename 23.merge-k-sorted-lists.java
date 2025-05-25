/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30204
 *
 * [23] 合并 K 个升序链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.PriorityQueue;

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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (!priorityQueue.isEmpty()) {
            ListNode smallestNode = priorityQueue.poll();
            curr.next = smallestNode;
            curr = curr.next;
            // 在构建新链表的同时添加节点到优先级队列，降低了时间复杂度
            if (smallestNode.next != null) {
                priorityQueue.add(smallestNode.next);
            }
        }
        return dummyHead.next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,4,5],[1,3,4],[2,6]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[]]\n
 * // @lcpr case=end
 * 
 */

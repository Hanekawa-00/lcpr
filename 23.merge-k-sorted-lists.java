/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30204
 *
 * [23] 合并 K 个升序链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;
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
    /**
     * 分割链表数组，化为小问题求解（将多个链表合并问题转化为两个链表合并问题）
     * 
     * @param lists
     * @return 合并后的链表头节点
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 创建最小堆（优先队列）,并且传入comparator
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        // 将所有头节点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        // 创建哑结点
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        // 其实就是把所有节点取出来顺便排序，即两步合成一步
        while (!minHeap.isEmpty()) {
            // 最优先（最小）出队
            ListNode smallestNode = minHeap.poll();
            curr.next = smallestNode;
            curr = curr.next;
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
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

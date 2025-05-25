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
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;  // 改名为 prev 更清晰
        
        while (true) {
            // 检查是否还有 k 个节点可以翻转
            ListNode kthNode = prev;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    // 不足 k 个节点，直接返回
                    return dummyHead.next;
                }
            }
            
            // 保存第 k+1 个节点（下一组的开始）
            ListNode nextGroupStart = kthNode.next;
            
            // 翻转当前的 k 个节点
            // groupStart 是当前组的原始头节点，翻转后会变成尾节点
            ListNode groupStart = prev.next;
            ListNode newGroupHead = reverseList(groupStart, k);
            
            // 重新连接链表
            prev.next = newGroupHead;           // 前一组连接到新头节点
            groupStart.next = nextGroupStart;   // 新尾节点连接到下一组
            
            // 更新 prev 为当前组的新尾节点，准备下一轮
            prev = groupStart;
        }
    }

    private ListNode reverseList(ListNode head, int count) {
        ListNode prev = null;
        ListNode current = head;
        
        for (int i = 0; i < count; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // 返回新的头节点（翻转后的头节点）
        return prev;  
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

/*
 * @lc app=leetcode.cn id=148 lang=java
 * @lcpr version=30204
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNodePrev = findMidNodePrev(head);
        ListNode nextHead = midNodePrev.next;
        midNodePrev.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(nextHead);
        return mergeTowSortedList(head1, head2);
    }

    private ListNode findMidNodePrev(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = low;
            low = low.next;
        }
        return prev;
    }

    private ListNode mergeTowSortedList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (head1 != null || head2 != null) {
            if (head1 == null || head2 == null) {
                node.next = head1 == null ? head2 : head1;
                break;
            } else if (head1 != null && head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        return dummy.next;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,5,3,4,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=21 lang=java
 * @lcpr version=30204
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode();
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            prev.next = list1;
            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            prev.next = list2;
            list2.next = mergeTwoLists(list1, list2.next);
        }
        return prev.next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,4]\n[1,3,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n[]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n[0]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Currency;
import java.util.Stack;

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
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // prev 指向每次要反转的 k 个节点的前驱节点
        ListNode prev = dummy;

        while (true) {
            // 1. 检查剩余节点是否足够 k 个
            ListNode groupTail = prev; // 临时指针用于检查
            for (int i = 0; i < k; i++) {
                groupTail = groupTail.next;
                if (groupTail == null) {
                    // 节点不足 k 个，结束循环
                    return dummy.next;
                }
            }
            // 如果循环正常结束，groupTail 指向当前分组的尾节点

            // 2. 记录下一组的起始节点（这步很关键，下面的操作会断开与这个节点的连接，这里要临时保存）
            ListNode nextGroupStart = groupTail.next;

            // 3. 断开当前分组与后面链表的连接 (虽然反转函数内部也会处理，但明确断开更清晰)
            // groupTail.next = null; // 这步可以省略，因为反转函数会处理

            // 4. 获取当前分组的头节点
            ListNode groupHead = prev.next;

            // 5. 反转当前分组 [groupHead, groupTail]
            // 调用一个辅助函数来反转这个子链表
            // 假设 reverseList 返回反转后的新头节点
            prev.next = reverseListHelper(groupHead, k); // 将 prev 指向反转后的新头

            // 6. 将反转后的尾部（原来的 groupHead）连接到下一组的起始节点
            groupHead.next = nextGroupStart; // groupHead 在反转后变成了尾部

            // 7. 移动 prev 指针到下一分组的前驱位置 (即当前分组反转后的尾部)
            prev = groupHead; // groupHead 现在是当前已处理部分的尾节点
        }
    }

    /**
     * 辅助函数：反转链表的前 k 个节点 (迭代法)
     * 假设调用者已确保存在至少 k 个节点
     * 返回反转后的新头节点
     */
    private ListNode reverseListHelper(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        // 循环结束后, prev 是反转后的新头节点
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

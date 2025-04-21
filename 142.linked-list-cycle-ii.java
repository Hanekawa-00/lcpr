/*
 * @lc app=leetcode.cn id=142 lang=java
 * @lcpr version=30204
 *
 * [142] 环形链表 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode meetNode = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetNode = slow;
                break;
            }
        }
        // 未找到相遇点
        if (meetNode == null) {
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = meetNode;
        // 分别从相遇点和起始点开始遍历，再次相遇即是入环节点
        /*
         * 假设链表头到环入口的距离是 a。
         * 环入口到快慢指针相遇点的距离是 b。
         * 相遇点到环入口的距离是 c。环的长度 L = b + c。
         * 当 slow 和 fast 相遇时：
         * slow 走过的距离 = a + b
         * fast 走过的距离 = a + b + k * L (其中 k 是 fast 比 slow 多绕环的圈数，k >= 1)
         * 因为 fast 的速度是 slow 的两倍，所以 fast 走过的距离也是 slow 的两倍： a + b + k * L = 2 * (a + b)
         * 简化等式：k * L = a + b
         * 我们想找到 a（头到入口的距离）。从上式看，a = k * L - b。
         * 将 L = b + c 代入：a = k * (b + c) - b = k*b + k*c - b = (k-1)b + k*c。这还不够直观。
         * 换个角度看 a = k * L - b。我们知道 c = L - b。
         * 所以 a = k * L - b = (k - 1) * L + L - b = (k - 1) * L + c。
         * 这个等式 a = (k - 1) * L + c 的含义是：从链表头到环入口的距离 (a) 等于从相遇点到环入口的距离 (c) 加上整数倍 (k-1)
         * 的环长 (L)。
         * 因此，如果我们一个指针从头开始走 a 步，另一个指针从相遇点开始走 a 步（也就是走 (k-1)L + c
         * 步），它们最终都会到达环的入口点。由于从相遇点走 c 步就回到了入口点，再走 (k-1)L
         * 步还是在入口点。所以，两个指针同时一步一步走，它们必定在环入口相遇。
         */
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,0,-4]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n-1\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=
 *
 * [239] 滑动窗口最大值
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        // 窗口大小为1的话，直接返回原数组
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        // 双端队列维护单调递增的索引（为什么使用索引？因为这样能够方便确认窗口位置）
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 维护单调递增的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 窗口滑动，移除最左边（队首）的元素,保证最大值在窗口范围
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 窗口形成的话就更新（在i小于k时无法形成大小为k的窗口）
            if (i >= k - 1) {
                // 队首为窗口内最大值
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3,-1,-3,5,3,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=LCR 188 lang=java
 * @lcpr version=30204
 *
 * [LCR 188] 买卖芯片的最佳时机
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int bestTiming(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        // dp[i]维护第i天可以获得最大利润
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            // 这天按照昨天的计划或者卖出
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[len - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3, 6, 2, 9, 8, 5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [8, 12, 15, 7, 3, 10]\n
 * // @lcpr case=end
 * 
 */

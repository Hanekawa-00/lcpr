/*
 * @lc app=leetcode.cn id=121 lang=java
 * @lcpr version=30204
 *
 * [121] 买卖股票的最佳时机
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // dp[i]维护第i天的最大利润=i天内最大卖出-最小购入
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [7,1,5,3,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,6,4,3,1]\n
 * // @lcpr case=end
 * 
 */

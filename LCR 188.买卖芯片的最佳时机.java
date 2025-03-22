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
        // minPrice用来维护第i天前最小购入价格
        int[] minPrice = new int[len + 1];
        // 初始化第一天前购入价格（理论上不可能）
        minPrice[1] = Integer.MAX_VALUE;
        // 初始化前一天的价格，比较的基准
        int pre = prices[0];
        for (int i = 2; i < minPrice.length; i++) {
            // 向后遍历不断更新
            minPrice[i] = Math.min(pre, minPrice[i - 1]);
            pre = prices[i - 1];
        }
        // dp[i]用来表示前i天最大利润
        int[] dp = new int[len + 1];
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            int curr = prices[i - 1];
            // 这天之前的最小购入价
            int min = minPrice[i];
            dp[i] = Math.max(dp[i - 1], curr - min);
        }
        return dp[len];
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

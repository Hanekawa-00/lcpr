/*
 * @lc app=leetcode.cn id=LCR 161 lang=java
 * @lcpr version=30204
 *
 * [LCR 161] 连续天数的最高销售额
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSales(int[] sales) {
        // dp[i]表示以第i天结尾的最大销售额
        int[] dp = new int[sales.length];
        dp[0] = sales[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] > 0 ? sales[i] + dp[i - 1] : sales[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-2,1,-3,4,-1,2,1,-5,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,4,-1,7,8]\n
 * // @lcpr case=end
 * 
 */

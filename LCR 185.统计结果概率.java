/*
 * @lc app=leetcode.cn id=LCR 185 lang=java
 * @lcpr version=
 *
 * [LCR 185] 统计结果概率
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public double[] statisticsProbability(int num) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= num; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 */

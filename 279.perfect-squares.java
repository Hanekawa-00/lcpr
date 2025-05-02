/*
 * @lc app=leetcode.cn id=279 lang=java
 * @lcpr version=30204
 *
 * [279] 完全平方数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        // dp[i] 维护组成i所需要的最少的完全平方数
        int[] dp = new int[n + 1];
        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 假设j*j是组成i的最后一个完全平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 13\n
 * // @lcpr case=end
 * 
 */

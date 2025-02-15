/*
 * @lc app=leetcode.cn id=279 lang=java
 * @lcpr version=30204
 *
 * [279] 完全平方数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numSquares(int n) {
        // 创建dp，用来维护组成数字i的最小完成平方数数量
        int[] dp = new int[n + 1];
        // 初始化dp,01
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 初始化i中的数值，最坏情况为i个1组成的
            dp[i] = i;
            // 一个一个进行尝试
            for (int j = 1; j * j <= i; j++) {
                // 这里的dp[i - j * j]肯定比i小，所以成立
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

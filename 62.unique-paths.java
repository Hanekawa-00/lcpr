/*
 * @lc app=leetcode.cn id=62 lang=java
 * @lcpr version=30204
 *
 * [62] 不同路径
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j]维护到达[i,j]坐标的路径和
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 7\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n3\n
 * // @lcpr case=end
 * 
 */

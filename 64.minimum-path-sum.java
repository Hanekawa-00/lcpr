/*
 * @lc app=leetcode.cn id=64 lang=java
 * @lcpr version=30204
 *
 * [64] 最小路径和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;// 行数
        int n = grid[0].length; // 列数
        // dp[i][j]表示到[i,j]位置的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化第一行第一列
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3,1],[1,5,1],[4,2,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6]]\n
 * // @lcpr case=end
 * 
 */

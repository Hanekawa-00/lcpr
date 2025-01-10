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
        int m = grid.length;
        int n = grid[0].length;
        // 维护每一个节点的最小路径
        int[][] dp = new int[m][n];
        int sum = 0;
        // 初始化 第一列和第一行
        for (int i = 0; i < m; i++) {
            sum = sum + grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + grid[0][i];
            dp[0][i] = sum;
        }
        // 逐行计算最短路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 每个节点的最短路径根据该节点上面的和左面的节点的最小路径计算而得（上一个节点的最小路径）
                // dp[i][j] = (dp[i - 1][j] > dp[i][j - 1] ? dp[i][j - 1] : dp[i - 1][j]) +
                // grid[i][j];
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
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

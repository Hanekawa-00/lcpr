/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30204
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 行数
        int rows = grid.length;
        // 列数
        int cols = grid[0].length;
        int islandCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 每次遇到1就会把它周围的（也就是整块陆地）所有1都更新为0,表示已经访问
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 遍历到边界或者达到陆地边界，即下一个为0
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }
        // visited已访问，更新这个点为0, 下次不会被遍历（视为陆地）
        grid[row][col] = '0';
        // 每个点右四个路径，递归周围的陆地节点
        dfs(grid, row + 1, col); // 下
        dfs(grid, row - 1, col);// 上
        dfs(grid, row, col + 1); // 右
        dfs(grid, row, col - 1);// 左

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0",
 * "0","0","0"]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0",
 * "0","1","1"]]\n
 * // @lcpr case=end
 * 
 */

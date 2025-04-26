/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30204
 *
 * [200] 岛屿数量
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int landCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 只要发现陆地，就开始dfs，将这一整块陆地全部变成 ‘0’
                if (grid[i][j] == '1') {
                    landCount++;
                    landHelper(grid, i, j);
                }
            }
        }
        return landCount;
    }

    private void landHelper(char[][] grid, int i, int j) {
        // 边界条件：越界或者遇到海洋
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // 上下左右暴力遍历
        landHelper(grid, i - 1, j);
        landHelper(grid, i + 1, j);
        landHelper(grid, i, j - 1);
        landHelper(grid, i, j + 1);
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

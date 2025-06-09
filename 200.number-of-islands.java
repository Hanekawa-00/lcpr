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
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] records = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (records[i][j] || grid[i][j] == '0') {
                    continue;
                }
                helper(grid, records, i, j);
                count++;
            }
        }
        return count;
    }

    private void helper(char[][] grid, boolean[][] records, int i, int j) {
        if (j < 0
                || j >= grid[0].length
                || i < 0
                || i >= grid.length
                || grid[i][j] == '0'
                || records[i][j]) {
            return;
        }
        records[i][j] = true;
        helper(grid, records, i + 1, j);
        helper(grid, records, i, j + 1);
        helper(grid, records, i - 1, j);
        helper(grid, records, i, j - 1);
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

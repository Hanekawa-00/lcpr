/*
 * @lc app=leetcode.cn id=LCR 129 lang=java
 * @lcpr version=30204
 *
 * [LCR 129] 字母迷宫
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean wordPuzzle(char[][] grid, String target) {
        if (grid == null || grid.length == 0 || target == null || target.length() == 0) {
            return false;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // 遍历每个单元格，作为起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, visited, i, j, target, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param grid
     * @param visited 维护当前路径上已经访问的单元格，用来判断是否访问该位置
     * @param i       行号
     * @param j       列号
     * @param s       目标单词
     * @param index   当前匹配单词位置索引
     * @return
     */
    public boolean dfs(char[][] grid, boolean[][] visited, int i, int j, String s, int index) {
        if (index == s.length()) {
            return true;
        }
        // 检查边界条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]
                || grid[i][j] != s.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        // 四个方向，左右上下
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        // 四个方向尝试遍历
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (dfs(grid, visited, newX, newY, s, index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
 * // @lcpr case=end
 * 
 */

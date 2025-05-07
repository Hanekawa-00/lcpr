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
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(grid, target, visited, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, String target, boolean[][] visited, int i, int j, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != target.charAt(k)) {
            return false;
        }
        // 这里的长度判断必须在检查边界之后，因为上一层传入的k已经是+1的状态，可能会误判
        if (k == target.length() - 1) {
            return true; // 找到了，返回 true
        }
        visited[i][j] = true;
        // 定义上下左右四个方向的偏移量
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // 探索：尝试向四个方向进行深度优先搜索
        for (int[] direction : directions) {
            int nextI = i + direction[0]; // 计算下一个位置的行索引
            int nextJ = j + direction[1]; // 计算下一个位置的列索引
            // 递归调用：从下一个位置继续搜索目标字符串的下一个字符 (索引为 k + 1)
            // 注意：在这里不再需要检查 nextI, nextJ 是否越界或已访问，
            // 这些检查会在下一次 dfs 调用函数中进行。
            if (dfs(grid, target, visited, nextI, nextJ, k + 1)) {
                return true; // 如果从任何一个方向找到了完整的路径，立即返回 true
            }
        }
        // 回溯：如果在当前位置向所有方向探索后都没有找到完整的路径
        // 则撤销当前位置的访问标记
        visited[i][j] = false;
        // 如果从当前位置向所有方向探索都未能找到完整的路径，则返回 false
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

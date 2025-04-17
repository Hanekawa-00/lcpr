/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=30204
 *
 * [79] 单词搜索
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // 每个位置都有可能是起始点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        // 尝试路径上的字符不匹配
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {// 最终成功结果，会逐步递归到最上层
            return true;
        }
        // 标记已经访问
        visited[i][j] = true;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean res = false;
        for (int[] direction : directions) {
            int newi = i + direction[0], newj = j + direction[1];
            // 控制新坐标范围
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 这部很关键，防止重复
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, index + 1);// 递归点
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        // 回溯
        visited[i][j] = false;
        return res;
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

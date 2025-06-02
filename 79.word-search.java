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
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] records = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                records[i][j] = true;
                if (backtrack(board, records, word, i, j, 1)) {
                    return true;
                }
                records[i][j] = false;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] path, String word, int m, int n, int count) {
        if (board[m][n] != word.charAt(count - 1)) {
            return false;
        }
        if (count >= word.length()) {
            return true;
        }
        int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] posI : pos) {
            int newM = m + posI[0];
            int newN = n + posI[1];
            if (newM >= 0
                    && newM < board.length
                    && newN >= 0
                    && newN < board[0].length
                    && !path[newM][newN]) {
                path[newM][newN] = true;
                if (backtrack(board, path, word, newM, newN, count + 1)) {
                    path[newM][newN] = false;
                    return true;
                }
                path[newM][newN] = false;
            }
        }
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

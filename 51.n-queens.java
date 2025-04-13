/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30204
 *
 * [51] N 皇后
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        // 初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, n);
        return res;
    }

    /**
     * @param board
     * @param row   当前行数
     * @param n     棋盘大小
     * 
     */
    private void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            res.add(boardToStringList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    /**
     * 判断该位置是否安全是否可以放置皇后
     * 
     * @return
     */
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // 检查行（略）
        // 检查列(因为回溯法放置皇后的顺序是从上往下每行放置，所以不需要考虑row下面的行，下面两个判断同理)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> boardToStringList(char[][] board) {
        List<String> res = new ArrayList<>();
       for (char[] chars : board) {
            res.add(String.valueOf(chars));
       }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */

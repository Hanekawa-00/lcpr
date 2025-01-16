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
        if (word.isEmpty()) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 找到首字母
                if (board[i][j] == word.charAt(0)) {
                    // 维护已经访问的路径，相当于path
                    boolean[][] visited = new boolean[rows][cols];
                    // 初始化第一个字符为true
                    visited[i][j] = true;
                    if (backtrack(board, i, j, 1, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param x
     * @param y
     * @param nextIndex   下一个即将遍历到word的第nextIndex个字符
     * @param word
     * @param visited
     * @return
     */
    private boolean backtrack(char[][] board, int x, int y, int nextIndex, String word, boolean[][] visited) {
        // 如果已经到最后一个字符了，则直接返回true
        if (nextIndex == word.length()) {
            return true;
        }
        int rows = board.length, cols = board[0].length;
        // 定义四个方向，分别为左右上下
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // 分别对四个"方向"尝试
        for (int[] dir : directions) {
            // 下个字符的坐标
            int nx = x + dir[0];
            int ny = y + dir[1];
            // 判断边界条件、这个方向的路径有没有被走过（路径有没有记录）、这个方向的字符是否正确
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]
                    && board[nx][ny] == word.charAt(nextIndex)) {
                visited[nx][ny] = true;
                // 如果路径正确，则进入下一层
                if (backtrack(board, nx, ny, nextIndex + 1, word, visited)) {
                    return true;
                }
                // 回退
                visited[nx][ny] = false;
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

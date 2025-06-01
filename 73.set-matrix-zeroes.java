/*
 * @lc app=leetcode.cn id=73 lang=java
 * @lcpr version=30204
 *
 * [73] 矩阵置零
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 记录行是否要置零
        boolean[] rowIsZ = new boolean[rows];
        boolean[] colsIsZ = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowIsZ[i] = true;
                    colsIsZ[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            if (rowIsZ[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < cols; i++) {
            if (colsIsZ[i]) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,1,1],[1,0,1],[1,1,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
 * // @lcpr case=end
 * 
 */

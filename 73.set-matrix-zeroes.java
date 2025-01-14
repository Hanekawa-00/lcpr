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
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // 布尔数组记录需要置为0的行和列，达到去重记录的效果
        boolean[] rowZero = new boolean[rows];
        boolean[] colZero = new boolean[cols];
        
        // 遍历矩阵，记录包含0的行和列
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        
        // 根据记录设置行和列
        // 设置行
        for (int i = 0; i < rows; i++) {
            if (rowZero[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 设置列
        for (int j = 0; j < cols; j++) {
            if (colZero[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
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

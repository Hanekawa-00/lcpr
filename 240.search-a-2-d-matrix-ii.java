/*
 * @lc app=leetcode.cn id=240 lang=java
 * @lcpr version=30204
 *
 * [240] 搜索二维矩阵 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        /*
         * 从左下角或者右上角寻找，因为这两个点开始寻找只有一个维度是单调的
         * 左上角 (row = 0, col = 0): 这是最小值。如果 target >
         * matrix[0][0]，你无法决定是向右移动还是向下移动，因为两个方向的值都会变大。
         * 右下角 (row = m - 1, col = n - 1): 这是最大值。如果 target <
         * matrix[m-1][n-1]，你无法决定是向上移动还是向左移动，因为两个方向的值都会变小。
         * 对比二分查找，利用单调性能够实现
         */
        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j < cols) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (target < num) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
 * \n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
 * \n20\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=30204
 *
 * [48] 旋转图像
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下对称交换
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        // 对角交换，注意j的边界，比如说[0,1]和[1,0]不能同时出现
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n
 * // @lcpr case=end
 * 
 */

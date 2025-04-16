/*
 * @lc app=leetcode.cn id=74 lang=java
 * @lcpr version=30204
 *
 * [74] 搜索二维矩阵
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int d = matrix.length - 1;
        int targetRow = -1;
        // 找到目标所在行
        while (t <= d) {
            int midRow = (t + d) / 2;
            if (matrix[midRow][0] == target) {
                return true;
            }
            if (target > matrix[midRow][0]
                    && target <= matrix[midRow][matrix[0].length - 1]) {
                targetRow = midRow;
                break;
            }
            if (target > matrix[midRow][0]) {
                t = midRow + 1;
            } else {
                d = midRow - 1;
            }
        }
        if (targetRow == -1) {
            return false;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            }
            if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return matrix[targetRow][left] == target;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n13\n
 * // @lcpr case=end
 * 
 */

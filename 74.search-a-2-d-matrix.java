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
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0, low = rows - 1;
        while (up < low) {
            int mid = (up + low) / 2;
            if (target == matrix[mid][0]) {
                return true;
            }
            // target 大于中间的区间
            if (target > matrix[mid][cols - 1]) {
                up = mid + 1;
            } else if (target < matrix[mid][0]) {
                // target小于中间的区间
                low = mid - 1;
            } else {
                // target位于中间的区间
                up = mid;
                low = mid;
            }
        }
        // 对该行进行二分查找
        int left = 0, right = matrix[0].length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == matrix[up][mid]) {
                return true;
            }
            if (target > matrix[up][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return matrix[up][left] == target;
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

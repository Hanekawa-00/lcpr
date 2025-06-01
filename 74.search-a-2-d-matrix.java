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
        int m = 0, n = rows - 1;
        int targetRow = -1;
        while (m < n) {
            int mid = (m + n) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                n = mid - 1;
            } else if (matrix[mid][0] < target && matrix[mid][cols - 1] >= target) {
                // 在区间内。找到目标行，target可能在这一行
                m = mid;
                break;
            } else {
                m = mid + 1;
            }
        }
        targetRow = m;
        m = 0;
        n = cols - 1;
        while (m <= n) {
            int mid = (m + n) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                n = mid - 1;
            } else {
                m = mid + 1;
            }
        }
        return false;
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

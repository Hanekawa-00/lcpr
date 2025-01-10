/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30204
 *
 * [54] 螺旋矩阵
 */

<<<<<<< HEAD
// @lcpr-template-start

// @lcpr-template-end
=======
>>>>>>> 9a8679c (螺旋矩阵)
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
<<<<<<< HEAD
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();

        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            // 向右遍历（top行）
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }

            // 向下遍历（right列）
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            
            // 当矩阵只剩一行或一列时，不需要进行向左和向上的遍历
            if (left < right && top < bottom) {
                // 向左遍历（bottom行）
                for (int col = right - 1; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                // 向上遍历（left列）
                for (int row = bottom - 1; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
=======
        int length = matrix[0].length;
        int width = matrix.length;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - 2 * i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i + 1; j < width - 2 * i; j++) {
                res.add(matrix[j][length - 1 - i]);
            }
            for (int j = length - 2 * i; j >= i; j--) {
                res.add(matrix[width - 1 - i][j]);
            }
            for (int j = width - 2 * i; j >= i + 1; j--) {
                res.add(matrix[j - 1][i]);
            }
>>>>>>> 9a8679c (螺旋矩阵)
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
 * // @lcpr case=end
 * 
 */

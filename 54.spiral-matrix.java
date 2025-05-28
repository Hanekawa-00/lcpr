/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30204
 *
 * [54] 螺旋矩阵
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        int rows = matrix.length;
        int cals = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cals - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                resList.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                resList.add(matrix[i][right]);
            }
            right--;
            // 防止越界重复添加，添加if判断 top++
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    resList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    resList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return resList;
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

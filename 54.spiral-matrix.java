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
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        // 初始化上下左右边界值
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> resList = new ArrayList<>();
        // 螺旋遍历一直缩小边界，直至重合
        while (top <= bottom && left <= right) {
            // top行
            for (int i = left; i <= right; i++) {
                resList.add(matrix[top][i]);
            }
            // 更新top
            top++;
            if (top <= bottom && left <= right) {// 这里的=很关键，top是刚刚更新的
                // right列
                for (int i = top; i <= bottom; i++) {// 因为这里top已经++了，所以直接从top开始
                    resList.add(matrix[i][right]);
                }
                right--;
            }
            // 检查bottom行是否还有数字
            if (top <= bottom && left <= right) {
                // bottom行
                for (int i = right; i >= left; i--) {
                    resList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 检查是left列是否还有数字
            if (top <= bottom && left <= right) {
                // left列
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

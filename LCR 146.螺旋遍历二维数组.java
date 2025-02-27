/*
 * @lc app=leetcode.cn id=LCR 146 lang=java
 * @lcpr version=30204
 *
 * [LCR 146] 螺旋遍历二维数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int rows = array.length;
        int cols = array[0].length;
        int[] res = new int[rows * cols];
        int index = 0;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        while (top <= bottom && left <= right) {
            // 遍历最上层
            for (int i = left; i <= right; i++) {
                res[index] = array[top][i];
                index++;
            }
            // 收缩
            top++;
            for (int i = top; i <= bottom; i++) {
                res[index] = array[i][right];
                index++;
            }
            right--;
            // 检查是否剩余行，如果之前遍历最上层已经是最后一层，那么top++之后已经超过了bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[index] = array[bottom][i];
                    index++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[index] = array[i][left];
                    index++;
                }
                left++;
            }
        }
        return res;
    }
}

// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[8,9,4],[7,6,5]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]\n
 * // @lcpr case=end
 * 
 */

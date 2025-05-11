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
        if (array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int m = array.length;
        int n = array[0].length;
        int[] res = new int[m * n];
        // 维护边界值,在遍历的过程中逐步缩小边界[上下左右边界]
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int x = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[x++] = array[top][i];
            }
            top++;
            if (top > bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                res[x++] = array[i][right];
            }
            right--;
            if (right < left)
                break;
            for (int i = right; i >= left; i--) {
                res[x++] = array[bottom][i];
            }
            bottom--;
            if (bottom < top)
                break;
            for (int i = bottom; i >= top; i--) {
                res[x++] = array[i][left];
            }
            left++;
            // if (left > right)
            //     break;
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

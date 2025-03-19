/*
 * @lc app=leetcode.cn id=LCR 191 lang=java
 * @lcpr version=
 *
 * [LCR 191] 按规则计算统计结果
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] statisticalResult(int[] arrayA) {
        int n = arrayA.length;
        if (n == 0) {
            return new int[] {};
        }
        int[] arrayB = new int[n];
        // 计算每个数字左边的乘积（从左向右遍历，不受右边的数影响）
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            arrayB[i] = leftProduct;
            // 更新左边乘积
            leftProduct *= arrayA[i];
        }
        // 计算每个数的右边乘积并和原来的左边乘积相乘
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 这里其实是两步骤，先计算右边乘积，再与左边乘积相乘
            arrayB[i] *= rightProduct;
            rightProduct *= arrayA[i];
        }
        return arrayB;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2, 4, 6, 8, 10]\n
 * // @lcpr case=end
 * 
 */

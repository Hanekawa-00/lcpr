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
        if (arrayA == null || arrayA.length == 0) {
            return new int[0];
        }
        int n = arrayA.length;
        int[] leftDp = new int[n];
        leftDp[0] = 1;
        int[] rightDp = new int[n];
        rightDp[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            leftDp[i] = leftDp[i - 1] * arrayA[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightDp[i] = rightDp[i + 1] * arrayA[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = leftDp[i] * rightDp[i];
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2, 4, 6, 8, 10]\n
 * // @lcpr case=end
 * 
 */

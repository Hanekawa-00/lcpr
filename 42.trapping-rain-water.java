/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30204
 *
 * [42] 接雨水
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {

    public int trap(int[] height) {
        // leftDp[i]表示i左边最高的柱子高度
        int[] leftDp = new int[height.length];
        int[] rightDp = new int[height.length];
        leftDp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i - 1]);
        }
        rightDp[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int curr = Math.min(leftDp[i], rightDp[i]) - height[i];
            if (curr >= 0) {
                res += curr;
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,0,2,1,0,1,3,2,1,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,2,0,3,2,5]\n
 * // @lcpr case=end
 * 
 */

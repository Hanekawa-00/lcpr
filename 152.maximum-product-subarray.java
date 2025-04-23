/*
 * @lc app=leetcode.cn id=152 lang=java
 * @lcpr version=30204
 *
 * [152] 乘积最大子数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {

    public int maxProduct(int[] nums) {
        // dpMax[i]维护包含nums第i个元素（以nums[i]结尾）最大子数组乘积
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int res = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            // 因为nums[i] 可能是负数，乘上一个最小值就成为了最大值，故作比较（有点无脑）
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,-2,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-2,0,-1]\n
 * // @lcpr case=end
 * 
 */

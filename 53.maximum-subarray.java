/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=30204
 *
 * [53] 最大子数组和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-2,1,-3,4,-1,2,1,-5,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,4,-1,7,8]\n
 * // @lcpr case=end
 * 
 */

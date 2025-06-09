/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30204
 *
 * [198] 打家劫舍
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    // dp[i]是偷到第i个房屋所能得到的最大金额
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    if (nums.length == 1) {
      return dp[0];
    }
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < dp.length; i++) {
      // 这里为什么使用dp[i-2]
      // 选择了nums[i],所以不能选nums[i-1]
      // 而dp[i-1]又有可能不选择nums[i-1]
      // 但是我们不妨想一下，不选择nums[i-1]时，dp[i-1] = dp[i-2]
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,7,9,3,1]\n
 * // @lcpr case=end
 * 
 */

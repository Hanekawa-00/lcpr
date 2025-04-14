/*
 * @lc app=leetcode.cn id=55 lang=java
 * @lcpr version=30204
 *
 * [55] 跳跃游戏
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 跳跃游戏
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // dp[i]用来维护跳跃i步数所能达到的最远距离
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        if (dp[1] >= nums.length - 1) {
            return true;
        }
        for (int i = 2; i < dp.length; i++) {
            int maxReach = dp[i - 1];
            for (int j = dp[i - 2]; j <= dp[i - 1]; j++) {
                maxReach = Math.max(maxReach, nums[j] + j);
            }
            if (maxReach >= nums.length - 1) {
                return true;
            }
            dp[i] = maxReach;
        }
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,1,1,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,1,0,4]\n
 * // @lcpr case=end
 * 
 */

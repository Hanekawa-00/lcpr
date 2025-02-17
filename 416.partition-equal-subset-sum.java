/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30204
 *
 * [416] 分割等和子集
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果和为奇数，说明不可能分割为两个和相同的子数组
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp[i]用来维护从nums数组取出一些值，这些值的和正好为i是否为真
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;// 和为0则一定能够实现
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                // 选择num或者不选择num
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,5,11,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,5]\n
 * // @lcpr case=end
 * 
 */

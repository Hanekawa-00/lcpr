/*
 * @lc app=leetcode.cn id=LCR 127 lang=java
 * @lcpr version=30204
 *
 * [LCR 127] 跳跃训练
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int trainWays(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        if (num == 0) {
            return dp[0];
        }
        dp[1] = 1;
        if (num == 1) {
            return dp[1];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[num];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 */

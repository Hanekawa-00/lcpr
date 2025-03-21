/*
 * @lc app=leetcode.cn id=LCR 187 lang=java
 * @lcpr version=30204
 *
 * [LCR 187] 破冰游戏
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int iceBreakingGame(int num, int target) {
        int[] dp = new int[num + 1];
        dp[1] = 0;
        for (int i = 2; i <= num; i++) {
            dp[i] = (dp[i - 1] + target) % i;
        }
        return dp[num];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 7\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 12\n5\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30204
 *
 * [322] 零钱兑换
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            // 金额为0则不需要零钱
            return 0;
        }
        // dp用来维护i金额最少零钱数
        int[] dp = new int[amount + 1];
        // 为了自洽，这里初始化为一个大值
        Arrays.fill(dp, amount + 1);
        // 金额为0，则为零
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                // 如果coin小于i则说明可以尝试
                // 状态方程为min（dp[i],dp[i-coin]-1）
                // 其中dp[i]为上一次尝试获得的结果，dp[i-coin]+1中的+1是使用这次的coin进行尝试
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1, 2, 5]\n11\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n0\n
 * // @lcpr case=end
 * 
 */

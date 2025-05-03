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
        int[] dp = new int[amount + 1];
        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 假设最后一个硬币为coin，不断尝试并更新
            for (int j = 0; j < coins.length; j++) {
                // 如果dp[i - coins[j]]为MAX则直接跳过。
                // i >= coins[j]控制索引越界，越界说明不可能有这种组合实现，保留原来的值
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
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

/*
 * @lc app=leetcode.cn id=LCR 131 lang=java
 * @lcpr version=30204
 *
 * [LCR 131] 砍竹子 I
 */

// @lc code=start
class Solution {
    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len < 2) {
            return 0;
        }
        int[] dp = new int[bamboo_len + 1];
        dp[0] = 0;
        dp[1] = 1;
        // 统计dp其他状态
        for (int i = 2; i <= bamboo_len; i++) {
            // 初始化当前dp为0
            int curMax = 0;
            // 遍历每个可切分点，将长度为i的竹子切为j和(i-j)
            for (int j = 1; j < i; j++) {
                // 取不拆分时的整数值和继续拆分的最大乘积中的最大值
                /*
                 * 对于任意长度 i 来说，我们可以在每个合法位置 j（1 ≤ j < i）处做一次切割，
                 * 将竹子分为两部分：长度为 j 和 i -j。这一步是一次切割操作，但对于每一部分，我们可以选择：
                 * 不再切割：直接使用当前的段长，即使用 j 或 i - j；
                 * 继续切割：利用前面已经求得的最优子解，即使用 dp[j] 或 dp[i - j]。
                 */
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[bamboo_len];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 */

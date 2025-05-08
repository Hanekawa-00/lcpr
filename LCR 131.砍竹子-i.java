/*
 * @lc app=leetcode.cn id=LCR 131 lang=java
 * @lcpr version=30204
 *
 * [LCR 131] 砍竹子 I
 */

// @lc code=start
class Solution {
    public int cuttingBamboo(int bamboo_len) {
        int[] dp = new int[bamboo_len + 1];
        dp[0] = 0;// 不存在，置零方便计算
        dp[1] = 0;// 长度为1无法分割
        dp[2] = 1;// 只能被分成1*1
        for (int i = 3; i < dp.length; i++) {
            // 假设分割点为j（这里为了方便计算控制其中一部分j长度不变，计算i-j这部分的最大乘积）
            for (int j = 1; j <= i; j++) {
                // i-j这段有两个选择：保留长度，或者切割
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
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

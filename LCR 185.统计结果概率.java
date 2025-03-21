/*
 * @lc app=leetcode.cn id=LCR 185 lang=java
 * @lcpr version=
 *
 * [LCR 185] 统计结果概率
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public double[] statisticsProbability(int num) {
        if (num == 0) {
            return new double[] {};
        }
        // dp[i][j] 表示骰子总和为i时，点数和为j的次数
        int[][] dp = new int[num + 1][6 * num + 1];
        // 初始化
        // 骰子总数为1时，点数和范围为[1,6],次数都为1次
        for (int i = 1; i <= 6; i++) { // 点数和不可能为0，所以不用考虑
            dp[1][i] = 1;
        }
        // 动态规划
        for (int i = 2; i <= num; i++) { // i维护骰子总数
            for (int j = i * 1; j <= i * 6; j++) { // j维护点数和，范围为[1*i,6*i]
                // 现在骰子总数i确定，点数和j确定，开始动态规划
                // 每轮循环都是为了计算dp[i][j]
                // 根据第i个骰子的点数可以有不同的结果（点数和为j的次数）
                for (int k = 1; k <= 6 && k <= j; k++) {// 防止索引越界，即j-k>=0， k <= j
                    // 当第i个骰子点数为k时，前面几个骰子的点数必定为j-k
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        // 计算概率,每个骰子有 6 种可能的结果（1, 2, 3, 4, 5, 6）。num 个骰子相互独立，因此总的可能性是每个骰子可能性的乘积。
        double totalCases = Math.pow(6, num); // 总的可能情况数
        double[] probabilities = new double[5 * num + 1]; // 概率数组长度为 6 * num - num + 1 = 5 * num + 1
        for (int j = num; j <= 6 * num; j++) {
            probabilities[j - num] = dp[num][j] / totalCases;
        }

        return probabilities;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 */

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
            return new double[0]; // 边界条件：num=0，返回空数组
        }

        final int faces = 6; // 每个骰子有6个面
        double total = Math.pow(faces, num); // 有num个骰子，总可能结果数：6^num

        // DP数组：dp[i][j] 表示投掷i个骰子，总和为j的次数
        long[][] dp = new long[num + 1][faces * num + 1]; // dp[0..num][0..6*num]

        // 初始化：第一个骰子
        for (int j = 1; j <= faces; j++) {
            dp[1][j] = 1; // 投1个骰子，总和j (1到6) 的次数是1
        }

        // DP迭代：从第2个骰子开始
        for (int i = 2; i <= num; i++) { // i: 骰子数
            for (int j = i; j <= i * faces; j++) { // j: 可能总和，从i到i*6
                dp[i][j] = 0; // 初始化
                for (int k = 1; k <= faces && k <= j; k++) { // k: 新骰子的点数
                    // 从前一个骰子(i-1)的总和(j-k) 转移
                    if (j - k >= 0) { // 确保总和合法
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        // 现在，dp[num][j] 就是投num个骰子，总和为j的次数
        double[] probabilities = new double[faces * num - num + 1]; // 数组长度：从num到6*num
        int index = 0; // 概率数组的索引，从0开始对应总和num
        for (int j = num; j <= num * faces; j++) { // j从num到6*num
            probabilities[index] = (double) dp[num][j] / total; // 概率 = 次数 / 总结果数
            index++;
        }

        return probabilities; // 返回概率数组
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

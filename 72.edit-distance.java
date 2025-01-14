/*
 * @lc app=leetcode.cn id=72 lang=java
 * @lcpr version=30204
 *
 * [72] 编辑距离
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp用来维护word1的前i个字符变为word2的前j个字符的编辑距离（步数）
        int[][] dp = new int[m + 1][n + 1];
        // 初始化dp
        for (int i = 0; i < m + 1; i++) {
            // 第一列，word2为空串，word1变为word2只能删除
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            // 第一行，word1为空串，word1变为word2只能插入
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 如果word1的第i个字符和word2的第j个字符相同
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 不需要操作
                    // 为什么是(i - 1)和(j - 1)？因为word1的前i-1个字符变为word2的前j-1个字符的编辑距离已经计算
                    // 而第i个字符和第j个字符相同，所以不需要操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则，取三种操作的最小值，+1是因为需要操作一次
                    // dp[i - 1][j - 1]+1：替换（word1的第i个字符替换为word2的第j个字符）
                    // dp[i - 1][j]+1：删除
                    // dp[i][j - 1]+1：插入
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "horse"\n"ros"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "intention"\n"execution"\n
 * // @lcpr case=end
 * 
 */

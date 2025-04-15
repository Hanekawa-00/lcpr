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
        // dp[i][j]表示word1前i个字符组成的字符串转化为word2前j各字符串所需要好的最少操作数
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第一行
        for (int j = 0; j <= n; j++) {
            // 空字符串转化为word2前j个字符所需要的最少操作数
            dp[0][j] = j; // 都是插入操作
        }
        // 初始化第一列
        for (int i = 0; i <= m; i++) {
            // word1转化为一个空字符串所需要的操作数
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i][j - 1], // 插入
                        Math.min(dp[i - 1][j], dp[i - 1][j - 1]) // 删除、替换
                    );
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

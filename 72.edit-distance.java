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
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j]表示将word1的前i个字符转化为word2的前j个字符所需要的最向操作数
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            // word1前i个字符转化为空字符（删除）
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            // 从空字符转化为word2的前i个字符
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 从删除、更换、插入三种选择最小
                    // 删除：将word1的第i个字符删除，转化为前i-1个字符转化为前j个字符的情况
                    // 插入：在word1的第i个字符后面插入word2相同的第j个字符，要注意的是前面多了1个字符
                    // 更换：将word1的第i个字符转化为word2的第j个字符
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[len1][len2];
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

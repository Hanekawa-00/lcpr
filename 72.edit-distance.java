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
        
        // dp[i][j] 表示 word1 的前 i 个字符和 word2 的前 j 个字符的编辑距离
        int[][] dp = new int[m + 1][n + 1];
        
        // 初始化边界条件
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // 填充 dp 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) { 
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1],  // 替换
                        Math.min(
                            dp[i - 1][j],  // 删除
                            dp[i][j - 1]   // 插入
                        )
                    ) + 1;
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

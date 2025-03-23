/*
 * @lc app=leetcode.cn id=5 lang=java
 * @lcpr version=30204
 *
 * [5] 最长回文子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // dp[i][j] 表示 s[i...j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        // 最长回文子串的长度
        int maxLength = 1;
        // 最长回文子串的起始位置
        int start = 0;
        // 所有长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 检查所有长度为 2 的子串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // 检查所有长度大于 2 的子串
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 如果 s[i] == s[j] 且 s[i+1...j-1] 是回文串，则 s[i...j] 也是回文串
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }
        // 返回最长回文子串
        return s.substring(start, start + maxLength);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "babad"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "cbbd"\n
 * // @lcpr case=end
 * 
 */

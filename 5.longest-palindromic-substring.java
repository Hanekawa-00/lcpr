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
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        // dp[i][j]表示s(i,j)是不是回文子串
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        String res = s.substring(0, 1);
        // 按照子串长度顺序遍历,这样可以避免长串未初始化的问题
        for (int length = 2; length <= len; length++) {
            // 左边界
            for (int i = 0; i <= len - length; i++) {
                // 右边界
                int j = i + length - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (length == 2) {
                    dp[i][j] = true;
                } else {
                    // 因为是按子串长度递增计算的，所以dp[i+1][j-1]必定已经计算
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    res = res.length() > length ? res : s.substring(i, j + 1);
                }
            }
        }
        return res;
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

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
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            flag[i][i] = true;
        }
        int startIndex = 0;
        int maxLen = 1;
        // L为子串长度
        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i <= s.length() - L; i++) {
                int j = i + L - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    flag[i][j] = false;
                } else {
                    if (i + 1 > j - 1) {
                        flag[i][j] = true;
                    } else {
                        flag[i][j] = flag[i + 1][j - 1];
                    }
                }
                if (flag[i][j]) {
                    maxLen = L;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
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

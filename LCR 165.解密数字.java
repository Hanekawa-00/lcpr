/*
 * @lc app=leetcode.cn id=LCR 165 lang=java
 * @lcpr version=
 *
 * [LCR 165] 解密数字
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 对于位置i，检查当前数字是否可以单独解码（不为0）
     * 检查当前数字与前一个数字是否可以组合解码（10-25范围内）
     * 累加这两种可能性得到总的解码方式数
     * 
     * @param ciphertext
     * @return
     */
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 1;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            if (curr != 0) {
                dp[i] += dp[i - 1];
            }
            int twoDigit = (prev - '0') * 10 + (curr - '0');
            if (twoDigit >= 10 && twoDigit <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return (int) dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 216612\n
 * // @lcpr case=end
 * 
 */

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
    public int crackNumber(int ciphertext) {
        String cipStr = String.valueOf(ciphertext);
        int n = cipStr.length();
        // dp[i] 表示密文的前i位
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n > 0) {
            dp[1] = 1;
        } else {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            // 情况1,i所在的字符可以和前一个字符进行组合（<25），单独解密+组合解密
            String sub = cipStr.substring(i - 2, i);
            int twoDigitVal = Integer.parseInt(sub);
            if (twoDigitVal >= 10 && twoDigitVal <= 25) {// 可能出现0x的组合，还是小于10,所以要排除
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                // 情况2 单独解密
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 216612\n
 * // @lcpr case=end
 * 
 */

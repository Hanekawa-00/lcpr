/*
 * @lc app=leetcode.cn id=LCR 126 lang=java
 * @lcpr version=30204
 *
 * [LCR 126] 斐波那契数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n == 1) {
            return 1;
        }
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] =( dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=LCR 168 lang=java
 * @lcpr version=
 *
 * [LCR 168] 丑数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 丑数序列是递增的，并且任何一个丑数都是由前面的某个丑数乘以 2、3 或 5 得到的
     * 
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        // 初始化第一个丑数
        dp[0] = 1;
        // 初始化指针，因为此时只有一个丑数
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < dp.length; i++) {
            int next2 = dp[p2] * 2;
            int next3 = dp[p3] * 3;
            int next5 = dp[p5] * 5;
            // 因为是有序排列，所以要取最小的排列
            dp[i] = Math.min(next2, Math.min(next3, next5));
            // 因为可能出现相同的情况，所以if要分开写
            if (next2 == dp[i]) {
                p2++;// 说明当前丑数已经被使用，指针后移
            }
            if (next3 == dp[i]) {
                p3++;
            }
            if (next5 == dp[i]) {
                p5++;
            }
        }
        return dp[n-1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 10\n
 * // @lcpr case=end
 * 
 */

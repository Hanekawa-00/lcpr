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
     * 任何一个丑数都可以由一个较小的丑数乘以2、3或5得到。
     * 
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        // 定义dp数组，dp[i]表示第i个丑数
        int[] dp = new int[n + 1];
        dp[1] = 1; // 第一个丑数是1

        // 定义三个指针，分别指向下一个要乘以2、3、5的丑数的位置
        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= n; i++) {
            // 计算下一个丑数的候选值
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;

            // 取最小值作为下一个丑数
            dp[i] = Math.min(Math.min(num2, num3), num5);

            // 更新指针（注意：可能有多个指针同时移动，比如当6既是2*3也是3*2时）
            if (dp[i] == num2)
                p2++;
            if (dp[i] == num3)
                p3++;
            if (dp[i] == num5)
                p5++;
        }

        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 10\n
 * // @lcpr case=end
 * 
 */

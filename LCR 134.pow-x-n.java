/*
 * @lc app=leetcode.cn id=LCR 134 lang=java
 * @lcpr version=30204
 *
 * [LCR 134] Pow(x, n)
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1.0;
        // 当前基数
        double currX = x;
        while (N != 0) {
            // 说明当前位为1
            if (N % 2 == 1) {
                ans *= currX;
            }
            // 右移一位
            N /= 2;
            // 如果幂次为1011，那么可以转化为2^1+2^2+2^4
            // 这里的平方相当于记录并累加次数即2^i变为2^(i+1),并在遇到1的时候乘入结果中
            currX = currX * currX;
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2.00000\n10\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2.10000\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2.00000\n-2\n
 * // @lcpr case=end
 * 
 */

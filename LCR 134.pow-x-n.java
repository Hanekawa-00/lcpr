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
        if (n == 0) {
            return 1;
        }
        // 处理n小于零的情况
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        // 初始化
        double res = 1.0;
        while (power > 0) {
            // 如果当前幂次方是奇数
            if (power % 2 == 1) {
                res *= x;
            }
            // 平方指数减半
            /*
             * 为什么？
             * 比如说原本是2^10
             * 可以转化为 （2^2）^5
             * 这就是快速幂
             * 如果减半后变为奇数，那么上一层条件判断就起效果了
             * 是奇数就先保存，更新res，即每次为奇数时将x乘到res中，直到刚好为1时，正好得到结果。
             * 注意 1 右移一位变为0
             */
            x *= x;
            power >>= 1;
        }
        return res;
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

/*
 * @lc app=leetcode.cn id=LCR 132 lang=java
 * @lcpr version=30204
 *
 * [LCR 132] 砍竹子 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    private static final int MOD = 1000000007;

    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len <= 1) { // 题目约束 bamboo_len >= 2
            return 0; 
        }
        if (bamboo_len == 2) { // 只能切成 1 + 1，乘积 1*1 = 1
            return 1;
        }
        if (bamboo_len == 3) { // 切成 1 + 2，乘积 1*2 = 2 (优于 1+1+1)
            return 2;
        }
        // 当 bamboo_len >= 4 时，应用贪心策略

        long result = 1;

        if (bamboo_len % 3 == 0) {
            // 如果恰好是3的倍数，例如 6 -> 3*3, 9 -> 3*3*3
            result = power(3, bamboo_len / 3);
        } else if (bamboo_len % 3 == 1) {
            // 如果余数是1，例如 4 -> 2*2, 7 -> 3*2*2 (或 3*4)
            // 将一个3和余下的1组合成4，即少一个3的因子，多一个4的因子
            // (bamboo_len / 3 - 1) 个 3， 和一个 4
            result = (power(3, bamboo_len / 3 - 1) * 4L) % MOD;
        } else { // bamboo_len % 3 == 2
            // 如果余数是2，例如 5 -> 3*2, 8 -> 3*3*2
            // (bamboo_len / 3) 个 3，和一个 2
            result = (power(3, bamboo_len / 3) * 2L) % MOD;
        }
        
        return (int) result;
    }

    // 快速幂取模
    private long power(long base, int exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 */

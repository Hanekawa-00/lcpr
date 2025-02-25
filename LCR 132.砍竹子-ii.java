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
    public int cuttingBamboo(int bamboo_len) {
        int mod = 1000000007;

        // 特殊处理：竹子砍分时至少要拆分一次
        if (bamboo_len == 2) {
            return 1; // 2 = 1 + 1, 1*1 = 1
        }
        if (bamboo_len == 3) {
            return 2; // 3 = 1 + 2, 1*2 = 2
        }

        // 大部分情况下，最佳策略是尽可能多拆分成 3
        int countOf3 = bamboo_len / 3;
        int remainder = bamboo_len % 3;

        // 当余数为 1 时，调整为 2+2 （即把最后一个3与余数1组合改为 2+2）
        if (remainder == 1) {
            countOf3--;
            remainder += 3; // remainder 变为 4
        }

        // 计算 3^countOf3 * remainder 的结果，每一步乘法都取模
        long product = 1;
        for (int i = 0; i < countOf3; i++) {
            product = (product * 3) % mod;
        }
        product = (product * remainder) % mod;

        return (int) product;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=136 lang=java
 * @lcpr version=30204
 *
 * [136] 只出现一次的数字
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int singleNumber(int[] nums) {
        // 0与任何数异或结果为任何数
        int res = 0;
        // 异或运算满足交换律和结合律，相同的两个异或运算结果为0
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,1,2,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */

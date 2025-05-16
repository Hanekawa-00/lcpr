/*
 * @lc app=leetcode.cn id=LCR 163 lang=java
 * @lcpr version=30204
 *
 * [LCR 163] 找到第 k 位数字
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findKthNumber(int k) {
        int digit = 1; // 位数,如0-9为1位数，10-99 是2位数
        long start = 1;// 当前位数的区间其实数字，如：1,10,100;后面有用，计算count
        long count = 9;// 当前位数区间所有的数排列起来的位数总和（如1*9,2*90,3*900）
        // 确定k的区间
        while (k > count) {
            k -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (k - 1) / digit;// 目标数字
        return Long.toString(num).charAt((k - 1) % digit) - '0';
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 */

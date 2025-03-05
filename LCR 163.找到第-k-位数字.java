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
        int digit = 1;
        long start = 1;
        long count = 9;
        while (k > count) {
            k -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (k - 1) / digit;
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

/*
 * @lc app=leetcode.cn id=LCR 135 lang=java
 * @lcpr version=30204
 *
 * [LCR 135] 报数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] countNumbers(int cnt) {
        int j = 1;
        for (int i = 0; i < cnt; i++) {
            j *= 10;
        }
        int[] res = new int[j - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 */

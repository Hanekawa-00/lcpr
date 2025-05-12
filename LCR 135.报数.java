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
        int size = 1;
        for (int i = 1; i <= cnt; i++) {
            size = size * 10;
        }
        int[] ans = new int[size - 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 */

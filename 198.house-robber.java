/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30204
 *
 * [198] 打家劫舍
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 这里的pre为dp[n-1]，也就是前面的最大可得金额
        int pre  = 0;
        // 本次最大金额dp[n]，可能是打过上家，不能打此家，可能是打过上上家，要打此家
        int curr =0;
      for (int num : nums) {
        int temp = curr;
        curr = Math.max(pre+num,curr);
        pre  = temp;
      }
        return curr;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,7,9,3,1]\n
// @lcpr case=end

 */


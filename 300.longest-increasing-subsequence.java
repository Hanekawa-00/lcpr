/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30204
 *
 * [300] 最长递增子序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i]维护以nums[i]结尾的最常递增子序列长度
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {// 如果j位置上的数小于i位置上的数，说明i可以拼接到以j为结尾的子序列后面
                    dp[i] = Math.max(dp[i], dp[j] + 1);// 不断更新取最大值
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,9,2,5,3,7,101,18]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,0,3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,7,7,7,7,7,7]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30204
 *
 * [300] 最长递增子序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp[i]用来表示以nums[i]作为结尾的子序列的最大长度
        int[] dp = new int[n];
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 如果nums[i]比nums[j]大，也就是第i个元素之前的一个元素比它小
                // 注意这里是直接加上以j为结尾的子序列，也就是说这里不用担心这其中是否是有序
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新maxLength
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
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

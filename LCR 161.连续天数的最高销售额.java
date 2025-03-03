/*
 * @lc app=leetcode.cn id=LCR 161 lang=java
 * @lcpr version=30204
 *
 * [LCR 161] 连续天数的最高销售额
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSales(int[] sales) {
        if (sales == null || sales.length == 0) {
            return 0;
        }
        // dp[i]是维护以i索引为结尾（一定要包含sales[i]这个元素，在这个元素基础上向前找或者只保留当前元素）的子数组中的最大子数组和
        int[] dp = new int[sales.length];
        // 初始化
        dp[0] = sales[0];
        int maxSum = dp[0];
        for (int i = 1; i < sales.length; i++) {
            // 如果dp[i -1]+sales[i]还小于 sales[i]说明前面子数组（以sales[i-1]为结尾的子数组）拖后腿了
            dp[i] = Math.max(dp[i - 1] + sales[i], sales[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-2,1,-3,4,-1,2,1,-5,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,4,-1,7,8]\n
 * // @lcpr case=end
 * 
 */

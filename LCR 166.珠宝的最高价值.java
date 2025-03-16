/*
 * @lc app=leetcode.cn id=LCR 166 lang=java
 * @lcpr version=
 *
 * [LCR 166] 珠宝的最高价值
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 同leetcode 64. 最小路径和
     * 注意点是初始化第一行和第一列
     * 
     * @param frame
     * @return
     */
    public int jewelleryValue(int[][] frame) {
        if (frame == null || frame.length == 0 || frame[0].length == 0) {
            return 0;
        }
        int rows = frame.length;
        int cols = frame[0].length;
        // dp[i][j]表示到达(i,j)位置时的最大价值(注意只能向右或向下移动)
        int[][] dp = new int[rows][cols];
        dp[0][0] = frame[0][0];
        // 初始化第一行
        for (int i = 1; i < cols; i++) {
            // 由于只能向右或向下移动，所以只能从左边移动过来
            dp[0][i] = dp[0][i - 1] + frame[0][i];
        }
        // 初始化第一列
        for (int i = 1; i < rows; i++) {
            // 由于只能向右或向下移动，所以只能从上边移动过来
            dp[i][0] = dp[i - 1][0] + frame[i][0];
        }
        // 从(1,1)位置开始遍历
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 到达(i,j)位置时的最大价值为(i-1,j)和(i,j-1)位置
                // 的最大价值中的最大值加上当前位置的价值(即左边或者上边或者说是从上一个位置来到这里的最大值)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3,1],[1,5,1],[4,2,1]]\n
 * // @lcpr case=end
 * 
 */

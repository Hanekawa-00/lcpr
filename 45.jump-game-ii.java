/*
 * 算法思路：
 * 1. 使用贪心算法，每次在当前能跳到的范围内选择能跳得最远的位置
 * 2. 维护三个变量：
 *    - jumps：记录跳跃次数
 *    - currentEnd：当前跳跃能到达的最远位置
 *    - farthest：下一次跳跃能到达的最远位置
 * 3. 遍历数组，不断更新farthest
 * 4. 当到达currentEnd时，说明必须进行一次跳跃才能继续前进
 * 5. 跳跃后更新currentEnd为farthest，表示新的跳跃范围
 * 6. 如果currentEnd已经可以到达终点，提前结束
 *
 * @lc app=leetcode.cn id=45 lang=java
 * @lcpr version=30204
 *
 * [45] 跳跃游戏 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // dp维护不同步数所能达到的最大距离
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        if (dp[1] >= nums.length - 1) {
            return 1;
        }
        for (int i = 2; i < dp.length; i++) {
            int maxReach = 0; // maxReach维护在[dp[i-2],dp[i-1]]区间内所能达到的最远距离
            for (int j = dp[i - 2]; j <= dp[i - 1]; j++) {
                maxReach = Math.max(maxReach, j + nums[j]);
            }
            if (maxReach >= nums.length - 1) {
                return i;
            }
            dp[i] = maxReach;
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,1,1,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,0,1,4]\n
 * // @lcpr case=end
 * 
 */

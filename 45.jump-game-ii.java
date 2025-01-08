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
        if (nums.length == 2 || nums[0] >= nums.length-1) {
            return 1;
        }
        int jumps = 0; // 记录最小跳跃次数
        int currentEnd = 0; // 当前跳跃能到达的最远位置
        int farthest = 0; // 下一次跳跃能到达的最远位置
        for (int i = 0; i < nums.length; i++) {
            // 更新当前能到达的最远位置
            farthest = Math.max(farthest, i + nums[i]);
            // 如果到达当前跳跃的边界
            if (i == currentEnd) {
                // 必须进行一次跳跃
                jumps++;
                // 更新下一次跳跃的边界
                currentEnd = farthest;
                // 如果已经可以到达终点，提前结束
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
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

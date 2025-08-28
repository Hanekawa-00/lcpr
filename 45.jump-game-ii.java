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
        // 获取数组长度
        int n = nums.length;

        // 边界情况：如果数组只有一个元素，无需跳跃
        if (n <= 1) {
            return 0;
        }

        // 初始化变量
        int jumps = 0; // 跳跃次数
        int current_end = 0; // 当前跳跃能到达的最远边界
        int farthest = 0; // 从当前区间出发，能到达的最最远的位置

        // 遍历数组，注意我们只需要遍历到倒数第二个元素
        // 因为当 i 到达 n-1 时，我们已经到达终点，不需要再跳了
        for (int i = 0; i < n - 1; i++) {
            // 1. 更新下一次跳跃能到达的最远距离
            // 在当前位置 i，我们可以跳到 i + nums[i]，
            // 我们要维护一个全局的 farthest，记录所有可能跳跃中的最大值
            farthest = Math.max(farthest, i + nums[i]);

            // 2. 判断是否需要进行下一次跳跃
            // 当 i 到达了 current_end，意味着我们已经走完了当前这一跳所能覆盖的所有范围
            // 此时，必须进行一次新的跳跃，来进入下一个覆盖范围
            if (i == current_end) {
                // 跳跃次数加 1
                jumps++;
                // 更新下一次跳跃的边界为我们之前计算出的 farthest
                current_end = farthest;

                // 一个小优化：如果新的边界已经能覆盖或超过终点，就可以提前结束了
                if (current_end >= n - 1) {
                    break;
                }
            }
        }

        // 返回总的跳跃次数
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

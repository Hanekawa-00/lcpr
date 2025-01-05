/*
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
        int jumps = 0; // 总跳跃次数
        int currentEnd = 0; // 覆盖范围的末尾，比farthest更新慢一步
        int farthest = 0; // 下一次跳跃能到的最远距离
        for (int i = 0; i < nums.length; i++) {
            // 计算能跳到的最远距离（不断更新尝试）
            farthest = Math.max(farthest, i + nums[i]);
            // 如果遍历达到现在覆盖范围的末尾
            if (i == currentEnd) {
                // 这里只是记录可以跳了，但实际上并未跳？？？而是通过遍历走到这里的
                jumps += 1;
                // 因为farthest是一步一步max得到，走过了覆盖范围内所有可能性，即在当前覆盖范围内得到的最大距离为farthest
                currentEnd = farthest;
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

/*
 * @lc app=leetcode.cn id=55 lang=java
 * @lcpr version=30204
 *
 * [55] 跳跃游戏
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 跳跃游戏
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 维护当前能够到达的最远位置
        int maxReach = 0;

        // 遍历数组中的每个位置
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置已经超过了最远可达位置，说明无法到达
            // 例如：nums = [3,2,1,0,4], i = 4时
            // maxReach = 3 (从位置0最多跳到位置3)
            // 但i = 4 > maxReach = 3，说明无法到达位置4
            // 这个判断是必要的提前终止条件，虽然去掉后最终结果相同，
            // 但会多执行一些不必要的循环
            if (i > maxReach) {
                return false;
            }

            // 更新最远可达位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 如果最远可达位置已经超过或等于最后一个位置，返回true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // 遍历结束后仍未到达最后一个位置，返回false
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,1,1,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,1,0,4]\n
 * // @lcpr case=end
 * 
 */

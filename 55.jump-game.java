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

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        // 维护从上一个maxReach到当前maxReach的区间内所能跳跃到的最远索引
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(curr, i + nums[i]);
            if (i == maxReach) {
                maxReach = curr;
                if (maxReach >= nums.length - 1) {
                    return true;
                }
            }
        }
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

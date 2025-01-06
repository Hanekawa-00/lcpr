/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=30204
 *
 * [53] 最大子数组和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = 0, res = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            res = Math.max(pre, res);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-2,1,-3,4,-1,2,1,-5,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,4,-1,7,8]\n
 * // @lcpr case=end
 * 
 */

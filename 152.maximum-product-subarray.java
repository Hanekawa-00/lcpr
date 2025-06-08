/*
 * @lc app=leetcode.cn id=152 lang=java
 * @lcpr version=30204
 *
 * [152] 乘积最大子数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        // maxDp[i]维护以第i个数字结尾的最大乘积
        int[] maxDp = new int[len];
        // 最小乘积
        int[] minDp = new int[len];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int res = maxDp[0];
        for (int i = 1; i < len; i++) {
            // 一共三种情况：
            /*
             * 1.这个数字本生是最大/最小乘积（前一个dp是0的情况下）
             * 2.这个数字与前一个最大乘积的乘积
             * 3.这个数字与前一个最小乘积的乘积（负数参与）
             * 通过这种手段相当于省略了多次判断
             */
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,-2,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-2,0,-1]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=238 lang=java
 * @lcpr version=30204
 *
 * [238] 除自身以外数组的乘积
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // leftdp[i]维护nums[0,i]的乘积，即nums[i]左边的元素乘积
        int[] leftdp = new int[nums.length];
        int[] rightdp = new int[nums.length];
        leftdp[0] = 1;
        rightdp[rightdp.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftdp[i] = leftdp[i - 1] * nums[i - 1];
        }
        for (int i = rightdp.length - 2; i >= 0; i--) {
            rightdp[i] = rightdp[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < rightdp.length; i++) {
            res[i] = leftdp[i] * rightdp[i];
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,1,0,-3,3]\n
 * // @lcpr case=end
 * 
 */

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
    /**
     * 总的思路就是，在一边遍历数组的过程中一边更新max
     * 就是拿当前最大值和max作比较，取最大
     * 细节是数组中存在负数，在遍历相乘的过程中当前最大值会变成当前最小值，最小值则相反
     * 这时候就需要一个imin来维护当前最小值
     * 
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素是小于零的，则交换当前最大值和当前最小值
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
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

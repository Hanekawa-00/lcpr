/*
 * @lc app=leetcode.cn id=35 lang=java
 * @lcpr version=30204
 *
 * [35] 搜索插入位置
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int midIndex = (l + r) / 2;
            int mid = nums[midIndex];
            if (mid == target) {
                return midIndex;
            } else if (mid < target) {
                l = midIndex + 1;
            } else {
                r = midIndex - 1;
            }
        }
        // 此时的l和r是相等的，因为在最后一次循环退出时l和r相等，这次的mid并未计算，也就是l和r的位置上的值并未和target进行比较 
        return nums[l] >= target ? l : l + 1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3,5,6]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,3,5,6]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,3,5,6]\n7\n
 * // @lcpr case=end
 * 
 */

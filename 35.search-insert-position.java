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
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 放在当前位置或者当前位置的后面
        return nums[left] < target ? left + 1 : left;
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

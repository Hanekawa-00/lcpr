/*
 * @lc app=leetcode.cn id=33 lang=java
 * @lcpr version=30204
 *
 * [33] 搜索旋转排序数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {

    /**
     * 二分搜索基于有序序列
     * 要控制在有序序列中搜索
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 说明[left , mid ]这个区间是有序的
            if (nums[mid] >= nums[left]) {
                // target 在这个区间内
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else { // 不在这个有序区间内
                    left = mid + 1;
                }
            } else { // 如果左区间不有序，右区间一定有序
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,5,6,7,0,1,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,5,6,7,0,1,2]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n0\n
 * // @lcpr case=end
 * 
 */

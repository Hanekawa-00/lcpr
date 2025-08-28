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
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // 注意这里是 <=
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            // 判断哪一段有序
            if (nums[left] <= nums[mid]) { // 左半段有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target 在左半段
                } else {
                    left = mid + 1; // target 在右半段
                }
            } else { // 右半段有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target 在右半段
                } else {
                    right = mid - 1; // target 在左半段
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

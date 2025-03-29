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
     * 虽然是在非正常的有序数组中二分查找
     * 但是只要发现有序区间就非常好处理
     * 总体思路就是：
     * 1.先找到有序区间
     * 2.判断是否在这个区间
     * 3.是则缩小查找区间到这个子区间
     * 4.否则继续在这个子区间之外的另一个区间内寻找
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 如果这里写成 nums[mid] > nums[left]，在 left == mid 的情况下会判断错误。用 >= 包含了 left == mid
            // 的情况，确保了当 mid 就是 left 时，[left, mid] 这段（实际上只有一个元素）被认为是“有序”的。
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
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

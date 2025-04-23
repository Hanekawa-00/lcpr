/*
 * @lc app=leetcode.cn id=153 lang=java
 * @lcpr version=30204
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 要找最小值并缩小区间，必须与right对比
            // 如果与left作对比，则只能说明[left,mid]是升序的，即使最小值在这个区间也同样成立，所以会导致误判
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 如果中间这个值小于right，则不能排除这个mid是目标值的可能性
                right = mid;
            }
        }
        return nums[left];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,4,5,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,5,6,7,0,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [11,13,15,17]\n
 * // @lcpr case=end
 * 
 */

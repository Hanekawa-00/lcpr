/*
 * @lc app=leetcode.cn id=31 lang=java
 * @lcpr version=30204
 *
 * [31] 下一个排列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从右边向左找到第一个开始减小（降序）的索引
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 找到第一个大于i所在位置数的索引
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 反转i后面的序列
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, right, left);
            right--;
            left++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,5]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=75 lang=java
 * @lcpr version=30204
 *
 * [75] 颜色分类
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int left = 0; // left的左边全是0
        int index = 0;
        int right = nums.length - 1; // right右边全是2
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left++);
                // 这里index为什么可以++？
                index++; 
            } else if (nums[index] == 2) {
                swap(nums, index, right--);
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,0,2,1,1,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,0,1]\n
 * // @lcpr case=end
 * 
 */

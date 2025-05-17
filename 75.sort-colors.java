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
        // current用来遍历，left、right分别是1,即中间那段的左右边界
        int left = 0, current = 0, right = nums.length - 1;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
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
 * // [2,0,2,1,1,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,0,1]\n
 * // @lcpr case=end
 * 
 */

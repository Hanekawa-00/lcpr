/*
 * @lc app=leetcode.cn id=189 lang=java
 * @lcpr version=30204
 *
 * [189] 轮转数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        // 翻转整个数组
        reverse(nums, 0, len - 1);
        // 翻转前k个元素
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,-100,3,99]\n2\n
 * // @lcpr case=end
 * 
 */

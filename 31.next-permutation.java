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
        // 我们从右向左找可“增大”的位置，是因为要尽可能保持高权重位不变。
        // 找到 i 后，在右边找大于 nums[i] 的最小的数来交换，是因为要让增大的幅度尽可能小。
        int i = nums.length - 2;
        // 从倒数第二个元素开始
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 这里i如果小于0 ，说明整个数组都是逆序的
        if (i >= 0) {
            // 以i所在位置的数字为i基准，从后往前找到第一个大于这个数字的位置
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        /*
         * 为什么要翻转？因为经过交换后，i 后面的序列已经没法保证是一个升序或者降序的状态了。为了保证 i 后面的权重位尽可能小，我们要把 i
         * 后面的序列变成升序。而我们知道，在交换之前 i 后面的序列是一个降序的序列（否则在第2步的时候，我们就找不到 i
         * 了），所以只需要把这个降序的序列翻转一下，就可以得到一个升序的序列。
         */
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
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

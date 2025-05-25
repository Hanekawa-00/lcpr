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
    /**
     * 如何找到第一个可以“增大”的位置？我们应该从右往左看。
     * 如果 nums[i] < nums[i+1]，那么 nums[i] 就是一个可以被替换成更大数字从而使整个序列变大的“枢轴点”。我们希望这个 i
     * 尽可能靠右，这样改变的幅度最小，得到的排列才是“下一个”更大的排列。
     * 一旦找到了这样的 nums[i]，我们应该用它右边哪个数字来替换它呢？为了得到“下一个”更大的排列，我们应该用 nums[i] 右边所有大于
     * nums[i] 的数中最小的那个数来替换。
     * 替换之后，nums[i] 右边的部分应该调整成最小的可能排列（即升序），这样才能保证整个序列是“下一个”更大的。
     * 
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        // 从右向左找到第一个正升序对
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从右往左找到第一个大于nums[i]的数（从右往左是升序）
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 翻转i后面的元素顺序，因为原来是降序排列的（即使是交换过元素）
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
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

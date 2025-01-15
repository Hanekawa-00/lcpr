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
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快排
     * 
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /**
     * 分割数组，左边为小于基准数的数组，右边为大于基准数的数组
     * 
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        // 以nums[left]为基准数
        int i = left, j = right;
        // 分割
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            // 找到第一个小于基准数和第一个大于基准数的元素
            swap(nums, i, j);
        }
        // 为什么可以交换这两个元素
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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

/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=30204
 *
 * [215] 数组中的第K个最大元素
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int target = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                // target在右区间
                left = index + 1;
            } else {
                // target在左区间
                right = index - 1;
            }
        }
    }

    /**
     * 分治出左右两个区间，分别小于大于中间的分割点（类似快排），该分割点位置index被找出来就不会变化
     * 
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left]; // 选择最左边的元素作为基准值
        int i = left + 1; // 指向左边扫描的指针，初始指向基准值右边第一个元素
        int j = right; // 指向右边扫描的指针，初始指向最右边的元素

        while (i <= j) { // 当左指针小于等于右指针时，继续扫描
            // 从左向右找到第一个大于基准值的元素
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            // 从右向左找到第一个小于基准值的元素
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            // 如果左右指针没有相遇，说明找到了需要交换的元素
            if (i < j) {
                swap(nums, i, j); // 交换左右指针指向的元素
                i++; // 左指针右移
                j--; // 右指针左移
            }
        }
        swap(nums, left, j); // 将基准值放到正确的位置 (j 是分割点)
        return j; // 返回分割点的索引
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=LCR 159 lang=java
 * @lcpr version=30204
 *
 * [LCR 159] 库存管理 III
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {

    public int[] inventoryManagement(int[] stock, int cnt) {
        quickSort(stock, 0, stock.length - 1);
        int[] res = new int[cnt];
        for (int i = 0; i < res.length; i++) {
            res[i] = stock[i];
        }
        return res;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right); // 正确分区
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        // 以 nums[left] 为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) // 先判断i，j位置是否越界，否则数组会索引越界
                j--; // 从右向左找首个小于基准数的元素
            while (i < j && nums[i] <= nums[left])
                i++; // 从左向右找首个大于基准数的元素
            swap(nums, i, j); // 交换这两个元素
        }
        swap(nums, i, left); // 将基准数交换至两子数组的分界线
        return i; // 返回基准数的索引
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
 * // [2,5,7,4]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,2,3,6]\n2\n
 * // @lcpr case=end
 * 
 */

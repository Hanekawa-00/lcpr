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
        if (stock == null) {
            return null;
        }
        quickSort(stock, 0, stock.length - 1);
        int[] res = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            res[i] = stock[i];
        }
        return res;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int bas = nums[left];
        int start = left;
        int end = right;
        while (left < right) {
            while (nums[right] > bas && left < right) {
                right--;
            }
            while (nums[left] <= bas && left < right) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[start];
        nums[start] = nums[left];
        nums[left] = temp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
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

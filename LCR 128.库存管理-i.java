/*
 * @lc app=leetcode.cn id=LCR 128 lang=java
 * @lcpr version=30204
 *
 * [LCR 128] 库存管理 I
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int inventoryManagement(int[] stock) {
        int low = 0;
        int high = stock.length - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (stock[middle] < stock[high]) {// 如果mid小于high上的数说明最小数字区间在[low, mid](包括mid)
                high = middle;
            } else if (stock[middle] > stock[high]) {// mid大于high，说明mid后面存在降序（旋转点）
                low = middle + 1;
            } else {
                high -= 1;
            }
        }
        return stock[low];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,5,8,3,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,7,9,1,2]\n
 * // @lcpr case=end
 * 
 */

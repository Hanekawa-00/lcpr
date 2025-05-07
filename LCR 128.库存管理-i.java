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
        int left = 0;
        int right = stock.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int curr = stock[mid];
            if (curr <= stock[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return stock[left];
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

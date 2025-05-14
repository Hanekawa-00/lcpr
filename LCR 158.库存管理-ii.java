/*
 * @lc app=leetcode.cn id=LCR 158 lang=java
 * @lcpr version=30204
 *
 * [LCR 158] 库存管理 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int inventoryManagement(int[] stock) {
        // 摩尔投票
        int votes = 0;
        int x = stock[0];
        for (int i = 0; i < stock.length; i++) {
            if (votes == 0) {
                x = stock[i];
                votes++;
                continue;
            }
            if (x == stock[i]) {
                votes++;
            } else {
                votes--;
            }
        }
        return x;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [6, 1, 3, 1, 1, 1]\n
 * // @lcpr case=end
 * 
 */

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
        // 假设votes是对最多元素的投票（这种投票有赞成票和反对票，votes是抵消完成后的票数）
        int x = 0, votes = 0;
        for (int num : stock) {
            // 如果当前没有候选商品
            if (votes == 0) {
                // 假设当前商品是候选商品
                x = num;
            }
            // 如果当前元素是等于x,认定为是投票，否则认定为是抵消
            votes += num == x ? 1 : -1;
        }
        // 最后存活下来的为最多票
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

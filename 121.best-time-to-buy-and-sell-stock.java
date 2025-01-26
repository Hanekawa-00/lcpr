/*
 * @lc app=leetcode.cn id=121 lang=java
 * @lcpr version=30204
 *
 * [121] 买卖股票的最佳时机
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 初始化最小售价（为了计算最小买入价）
        int minprice = Integer.MAX_VALUE;
        // 初始化最大利润
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [7,1,5,3,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,6,4,3,1]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=LCR 179 lang=java
 * @lcpr version=30204
 *
 * [LCR 179] 查找总价格为目标值的两个商品
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] twoSum(int[] price, int target) {
        int[] ans = new int[2];
        int right = price.length - 1;
        int left = 0;
        while (left < right) {
            int curr = price[left] + price[right];
            if (curr == target) {
                ans[0] = price[left];
                ans[1] = price[right];
                break;
            }
            //如果当前和偏大说明应该减小
            // 为什么不是left--，因为之前计算过了。
            //整个过程是left和right向中间靠
            if (curr > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3, 9, 12, 15]\n18\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [8, 21, 27, 34, 52, 66]\n61\n
 * // @lcpr case=end
 * 
 */

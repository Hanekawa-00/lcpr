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
        int left = 0, right = price.length - 1;
        while (left <= right) {
            int i = price[left];
            int j = price[right];
            int sum = i + j;
            if (sum == target) {
                return new int[] { i, j };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
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

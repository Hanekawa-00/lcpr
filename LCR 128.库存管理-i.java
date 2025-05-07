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
            if (curr < stock[right]) {
                right = mid;
            } else if (curr > stock[right]) {
                left = mid + 1;
            } else {
                // 注意这里可能出现重复元素，即mid可能与right的值相同，但是最小值在他们之间
                // 我们可以安全地将 right 减一。这是因为如果 stock[right] 是最小元素，那么 stock[mid] 也等于它，并且 mid 小于
                // right (除非 left == mid == right)。将 right 减一并不会错过最小元素。如果 stock[right]
                // 不是最小元素，将它排除掉也不会影响找到最小元素。
                right--;
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

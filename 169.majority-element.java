/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=30204
 *
 * [169] 多数元素
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int majorityElement = -1;
        for (int num : nums) {
            if (votes == 0) {
                majorityElement = num;
                votes++;
            } else {
                if (num != majorityElement) {
                    votes--;
                } else {
                    votes++;
                }
            }
        }
        return majorityElement;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,1,1,1,2,2]\n
 * // @lcpr case=end
 * 
 */

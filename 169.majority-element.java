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
        // 多数元素肯定是大于nums.length/2，那么选票抵消最后剩下的肯定是多数元素
        int candidate = -1; // 候选元素
        int count = 0; // 选票
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            // 无论是count++还是--,都可以看为数组内部抵消
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
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

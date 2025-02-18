/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30204
 *
 * [560] 和为 K 的子数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            for (int j = i; j < nums.length; j++) {
                current = current + nums[j];
                if (current == k) {
                    count++;
                    // 因为后面的元素还可能为则0，所以不能break
                    // break;
                }
            }
        }
        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,1]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n3\n
 * // @lcpr case=end
 * 
 */

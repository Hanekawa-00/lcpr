/*
 * @lc app=leetcode.cn id=283 lang=java
 * @lcpr version=30204
 *
 * [283] 移动零
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0; // 记录非0元素需要写入的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,0,3,12]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */

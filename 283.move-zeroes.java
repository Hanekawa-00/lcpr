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
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 等于0则跳过
                continue;
            }
            if (index < i) {
                // 初次进入此代码块时，index必定是0,因此是无用数据，所以直接替换，无需交换
                nums[index] = nums[i];
            }
            index++;
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
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

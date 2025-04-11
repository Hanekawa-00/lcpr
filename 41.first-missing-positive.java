/*
 * @lc app=leetcode.cn id=41 lang=java
 * @lcpr version=30204
 *
 * [41] 缺失的第一个正数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pre = i;
                break;
            }
        }
        // 第一个大于0的数不存在或者大于1，则直接返回1
        if (nums[pre] > 1 || nums[pre] < 0) {
            return 1;
        }
        for (int i = pre + 1; i < nums.length; i++) {
            // 其中可能有重复
            if (nums[i] == nums[pre] + 1 || nums[i] == nums[pre]) {
                pre = i;
                continue;
            } else {
                return nums[pre] + 1;
            }
        }
        return nums[pre] + 1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,4,-1,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,8,9,11,12]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30204
 *
 * [15] 三数之和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left, right;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 前一个数可能与当前数相同，会导致有重复的三元组组合
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 提前退出
            if (nums[i] > 0) {
                break;
            }
            left = i + 1;
            right = nums.length - 1;
            int newTarget = 0 - nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == newTarget) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 与二分查找不同的是可能不止有一种组合
                    left++;
                    right--;
                } else if (sum < newTarget) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-1,0,1,2,-1,-4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,0,0]\n
 * // @lcpr case=end
 * 
 */

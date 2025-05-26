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
        int n = nums.length;

        // 阶段一：原地放置数字
        // 目标：将数字 x 放到索引 x-1 的位置
        for (int i = 0; i < n; i++) {
            // 当 nums[i] 是一个有效的正数 (在 1 到 n 之间)
            // 并且 nums[i] 不在它应该在的位置 (nums[i] - 1 != i)
            // 并且 nums[i] 与它目标位置上的数不同 (避免与重复数字无限交换)
            // (nums[nums[i] - 1] != nums[i])
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i]-1]
                int targetIndex = nums[i] - 1;
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[i];
                nums[i] = temp;
            }
        }

        // 阶段二：查找第一个缺失的正数
        // 遍历数组，找到第一个 nums[i] != i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // i+1 是缺失的最小正数
            }
        }

        // 如果所有 1 到 n 的数字都存在，则缺失的最小正数是 n + 1
        return n + 1;
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

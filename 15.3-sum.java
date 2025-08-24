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
        List<List<Integer>> result = new ArrayList<>();
        // 边界条件：如果数组为空或长度小于3，无法构成三元组
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 1. 对数组进行排序，这是使用双指针的前提
        Arrays.sort(nums);

        // 2. 遍历数组，固定第一个数 nums[i]
        for (int i = 0; i < nums.length - 2; i++) {
            // 优化：如果固定的数已经大于0，由于数组是升序的，
            // 后面的数都大于0，三数之和不可能为0，可以直接结束循环。
            if (nums[i] > 0) {
                break;
            }

            // 去重：如果当前数字与前一个数字相同，则跳过，避免产生重复的三元组。
            // 注意 i > 0 的判断，防止索引越界。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3. 设置左右指针，在 nums[i] 之后的部分寻找另外两个数
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // 另外两个数的目标和

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // 找到了一个符合条件的三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 4. 去重：移动指针，并跳过所有重复的元素
                    // 跳过左指针的重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过右指针的重复元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动指针到下一个不同的元素
                    left++;
                    right--;

                } else if (sum < target) {
                    // 和太小，需要更大的数，左指针右移
                    left++;
                } else { // sum > target
                    // 和太大，需要更小的数，右指针左移
                    right--;
                }
            }
        }
        return result;
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

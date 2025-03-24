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
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        // 总体流程就是在这个已经排序好的数组中逐个遍历，再在这个元素后面的区间内找到另外能凑成0的两个数
        // 为什么只需要在后面的区间找？因为为了去重不能再包含有前面那个元素的三元组了。因为前面的遍历已经包含所有情况了（包含这个元素的三元组）
        for (int i = 0; i < nums.length; i++) {
            // 这个元素大于0说明后面的元素都大于0，因为是排序数组
            if (nums[i] > 0) { // 为什么没有==0，因为后面可能还有两个0
                break;
            }
            // 第一个元素相同，那么后面区间取出的元素组合结果会有重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                }
                if (sum > 0) {
                    right--;
                } else {// 注意这里如果sum = 0也会执行这段，为了选找下一个目标，其实right--也可以
                    left++;
                }
            }
        }
        return resList;
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

/*
 * @lc app=leetcode.cn id=75 lang=java
 * @lcpr version=30204
 *
 * [75] 颜色分类
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return; // 处理空数组或null数组的情况
        }

        int p0 = 0; // 指向0区域的右边界（下一个0应该放的位置）
        int curr = 0; // 当前处理的元素指针
        int p2 = nums.length - 1; // 指向2区域的左边界（上一个2应该放的位置）

        // 当 curr 指针没有超过 p2 指针时，继续处理
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 当前元素是0，与p0指向的元素交换
                swap(nums, curr, p0);
                p0++; // 0区域扩大
                curr++; // 处理下一个元素
            } else if (nums[curr] == 2) {
                // 当前元素是2，与p2指向的元素交换
                swap(nums, curr, p2);
                p2--; // 2区域扩大
                // curr 不增加，因为从p2换过来的元素需要重新判断
            } else { // nums[curr] == 1
                // 当前元素是1，它在正确的位置（相对于0和2区域），直接处理下一个
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,0,2,1,1,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,0,1]\n
 * // @lcpr case=end
 * 
 */

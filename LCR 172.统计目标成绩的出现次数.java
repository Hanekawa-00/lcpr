/*
 * @lc app=leetcode.cn id=LCR 172 lang=java
 * @lcpr version=
 *
 * [LCR 172] 统计目标成绩的出现次数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int countTarget(int[] scores, int target) {
        // 查找第一个等于 target 的位置
        int leftIdx = binarySearchHelper(scores, target, true);
        // 查找第一个大于 target 的位置
        int rightBoundary = binarySearchHelper(scores, target, false);
        
        // 如果 leftIdx 等于数组长度，或者 scores[leftIdx] 不等于 target，
        // 说明 target 不存在于数组中。
        if (leftIdx == scores.length || scores[leftIdx] != target) {
            return 0;
        }
        
        // target 出现的次数是 (第一个大于target的位置) - (第一个等于target的位置)
        // rightBoundary 是第一个大于 target 的位置的索引
        // leftIdx 是第一个等于 target 的位置的索引
        return rightBoundary - leftIdx;
    }

    /**
     * 辅助二分查找函数
     * @param nums 排序数组
     * @param target 目标值
     * @param findFirstEqual 如果为 true，查找第一个等于 target 的位置 (或者第一个大于 target 的位置，如果 target 不存在)
     *                       如果为 false，查找第一个严格大于 target 的位置
     * @return 对应的索引。如果找不到（例如数组为空，或所有元素都小于目标），可能返回 nums.length
     */
    private int binarySearchHelper(int[] nums, int target, boolean findFirstEqual) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length; // 初始化为数组长度，表示如果找不到，则目标位置在所有元素之后

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止整数溢出
            
            if (findFirstEqual) {
                // 查找第一个等于或大于 target 的元素
                if (nums[mid] >= target) {
                    ans = mid;       // mid 可能是解，或者解在左边
                    right = mid - 1; // 继续在左边找更小的索引
                } else {
                    left = mid + 1;  // 解在右边
                }
            } else {
                // 查找第一个严格大于 target 的元素
                if (nums[mid] > target) {
                    ans = mid;       // mid 可能是解，或者解在左边
                    right = mid - 1; // 继续在左边找更小的索引
                } else {
                    left = mid + 1;  // 解在右边
                }
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2, 2, 3, 4, 4, 4, 5, 6, 6, 8]\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1, 2, 3, 5, 7, 9]\n6\n
 * // @lcpr case=end
 * 
 */

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
        int leftIdx = binarySearch(scores, target, true);
        int rightIdx = binarySearch(scores, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < scores.length && scores[leftIdx] == target
                && scores[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        // ans用来维护第一个大于等于target的位置
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
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

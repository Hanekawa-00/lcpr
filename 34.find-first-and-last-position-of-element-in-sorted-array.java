/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=30204
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] index = {-1, -1};
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return index;
        }
        if (nums.length == 1) {
            index[0] = 0;
            index[1] = 0;
            return index;
        }
        int l = 0, r = nums.length - 1, first = -1, last = -1;
        while (l <= r) {
            int mid = nums[(r + l) / 2];
            if (target == mid) {
                int temp = (r + l) / 2;
                while (temp <= nums.length - 1 && nums[temp] == target) {
                    last = temp;
                    temp += 1;
                }
                temp = (r + l) / 2;
                while (temp >= 0 && nums[temp] == target) {
                    first = temp;
                    temp -= 1;
                }
                break;
            } else if (target > mid) {
                l = (r + l) / 2 + 1;
            } else {
                r = (r + l) / 2 - 1;
            }
        }
        index[0] = first;
        index[1] = last;
        return index;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,7,7,8,8,10]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,7,7,8,8,10]\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n0\n
 * // @lcpr case=end
 * 
 */

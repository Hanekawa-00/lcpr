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
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            return new int[] { -1, -1 };
        }
        int firstPosition = findFirstPosition(nums, index, target);
        int lastPosition = findLastPosition(nums, index, target);
        return new int[] { firstPosition, lastPosition };
    }

    private int findFirstPosition(int[] nums, int index, int target) {
        int i = index;
        while (i >= 0 && nums[i] == target) {
            i--;
        }
        return i + 1;
    }

    private int findLastPosition(int[] nums, int index, int target) {
        int j = index;
        while (j < nums.length && nums[j] == target) {
            j++;
        }
        return j - 1;
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

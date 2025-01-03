/*
 * @lc app=leetcode.cn id=33 lang=java
 * @lcpr version=30204
 *
 * [33] 搜索旋转排序数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        // 使用循环进行二分，每次缩小区间
        // 根据有序的部分来判断目标值是否在有序的那部分里。如果在，就缩小搜索范围到有序的那部分；否则，就去另一部分继续搜索。(相当于在子数组中继续进行查找)
        // 为什么每次都选择有序区间进行边界判断？假如每次都与mid进行比较的话，因为假如根据mid和target的比较选择了一个无序区间，很可能会错过target
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 二分数组，总有一边的区间是有序区间
            // 如果[0,mid]（左半部分）是有序区间
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    // target在有序区间[0,mid]内
                    r = mid - 1;
                } else {
                    // target在区间[mid,n-1]内
                    l = mid + 1;
                }
            } else {// 如果[mid,n-1]（右半部分）是有序区间
                if (nums[mid] < target && target <= nums[n - 1]) {
                    // 如果target在有序区间[mid,n-1]内，l右移缩小区间
                    l = mid + 1;
                } else {
                    // 如果target在区间[0,mid]
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,5,6,7,0,1,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,5,6,7,0,1,2]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n0\n
 * // @lcpr case=end
 * 
 */

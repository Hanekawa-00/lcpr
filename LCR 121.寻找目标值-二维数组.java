/*
 * @lc app=leetcode.cn id=LCR 121 lang=java
 * @lcpr version=30204
 *
 * [LCR 121] 寻找目标值 - 二维数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants.length == 0 || plants[0].length == 0) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i][0] > target) {
                break;
            }
            flag = binaryQuery(plants[i], target);
            if (flag) {
                break;
            }
        }
        return flag;
    }

    private boolean binaryQuery(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[2,3,6,8],[4,5,8,9],[5,9,10,12]]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,3,5],[2,5,7]]\n4\n
 * // @lcpr case=end
 * 
 */

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
        if (plants == null || plants.length == 0 || plants[0].length == 0) {
            return false;
        }
        int rows = plants.length;
        int cols = plants[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (plants[i][j] == target) {
                return true;
            } else if (plants[i][j] > target) {
                j--;
            } else {
                i++;
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

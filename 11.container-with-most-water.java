/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30204
 *
 * [11] 盛最多水的容器
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int currWidth = (right - left);
            int currArea;
            if (height[left] < height[right]) {
                currArea = currWidth * height[left];
                left++;
            } else {
                currArea = currWidth * height[right];
                right--;
            }
            max = Math.max(max, currArea);
        }
        return max;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,8,6,2,5,4,8,3,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1]\n
 * // @lcpr case=end
 * 
 */

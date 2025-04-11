/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30204
 *
 * [42] 接雨水
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 每个区域的水量公式：min(leftMax,rightMax) - height[i]
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        // 用来维护i左边最高的柱子高度
        int[] leftMax = new int[len];
        leftMax[0] = -1;
        int[] rightMax = new int[len];
        rightMax[len - 1] = -1;
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 1; i < rightMax.length - 1; i++) {
            int size = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (size > 0) {
                ans += size;
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,0,2,1,0,1,3,2,1,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,2,0,3,2,5]\n
 * // @lcpr case=end
 * 
 */

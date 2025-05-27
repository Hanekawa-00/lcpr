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

    public int trap(int[] height) {
        // 每个位置所能盛水量为左右最高的两个柱子中最矮的高度减去当前高度
        int len = height.length;
        int[] leftMaxDp = new int[len];
        leftMaxDp[0] = 0;
        int[] rightMaxDp = new int[len];
        rightMaxDp[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            leftMaxDp[i] = Math.max(leftMaxDp[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMaxDp[i] = Math.max(rightMaxDp[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int size = Math.min(leftMaxDp[i], rightMaxDp[i]) - height[i];
            if (size >= 0) {
                res += size;
            }
        }
        return res;
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

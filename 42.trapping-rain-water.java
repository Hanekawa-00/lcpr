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
     * 每个柱子上面的雨水格数=min(左边最高柱子，右边最高柱子)-当前柱子高度 （例外情况：结果为负数，判断为0）
     * 
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        // 中间数组，用来存储每一个柱子所对应的左右最高柱子
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        lmax[0] = 0;
        rmax[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            rmax[j] = Math.max(rmax[j + 1], height[j + 1]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.max(0, Math.min(lmax[i], rmax[i]) - height[i]);
        }
        return res;
    }

    /**
     * 双指针版本2
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // l,r是将要计算雨水格数的索引
        int l = 1, r = height.length - 2, lmax = height[0], rmax = height[height.length - 1], res = 0;
        // 双指针启动
        while (l <= r) {
            if (lmax <= rmax) {// 此时真实的rmax必然大于等于这个rmax，即lmax必然比真实的rmax小
                res += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l]);
                l++;
            } else {
                res += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r]);
                r--;
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

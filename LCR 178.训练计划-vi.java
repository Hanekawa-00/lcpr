/*
 * @lc app=leetcode.cn id=LCR 178 lang=java
 * @lcpr version=30204
 *
 * [LCR 178] 训练计划 VI
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int trainingPlan(int[] actions) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : actions) {
                // 取最后第i位累加
                bitSum += (num >> i) & 1;
            }
            // 对三取余
            int bitVal = bitSum % 3;
            // 构造ans的每一位（先左移i位确定位置，再使用或运算更新ans，由于ans是一位一位计算的，第i位再此时肯定是0）
            ans |= (bitVal << i);
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5, 7, 5, 5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [12, 1, 6, 12, 6, 12, 6]\n
 * // @lcpr case=end
 * 
 */

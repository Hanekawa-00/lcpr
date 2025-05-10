/*
 * @lc app=leetcode.cn id=LCR 139 lang=java
 * @lcpr version=30204
 *
 * [LCR 139] 训练计划 I
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] trainingPlan(int[] actions) {
        // i用来维护奇数的索引，j用来维护偶数的索引
        int i = 0, j = actions.length - 1;
        while (i < j) {
            // 从左往右找到第一个偶数
            while (i < j && actions[i] % 2 == 1) {
                i++;
            }
            // 从右往左找到第一个奇数
            while (i < j && actions[j] % 2 == 0) {
                j--;
            }
            // 交换
            int temp = actions[i];
            actions[i] = actions[j];
            actions[j] = temp;
        }
        return actions;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n
 * // @lcpr case=end
 * 
 */

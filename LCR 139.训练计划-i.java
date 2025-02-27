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
        int i = 0, j = actions.length - 1;
        while (i < j) {
            // 找到从当前索引开始首个偶数
            while (i < j && actions[i] % 2 == 1) {
                i++;
            }
            // 从右往左找到首个奇数
            while (i < j && actions[j] % 2 == 0) {
                j--;
            }
            // 交换两个奇偶位置
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

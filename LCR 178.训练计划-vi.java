/*
 * @lc app=leetcode.cn id=LCR 178 lang=java
 * @lcpr version=30204
 *
 * [LCR 178] 训练计划 VI
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    public int trainingPlan(int[] actions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int action : actions) {
            map.put(action, map.getOrDefault(action, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .map(entry -> entry.getKey())
                .orElse(-1);
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

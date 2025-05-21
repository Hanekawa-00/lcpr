/*
 * @lc app=leetcode.cn id=LCR 189 lang=java
 * @lcpr version=30204
 *
 * [LCR 189] 设计机械累加器
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int mechanicalAccumulator(int target) {
        // 利用短路特性
        boolean flag = target > 0 && (target += mechanicalAccumulator(target - 1)) > 0;
        return target;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 7\n
 * // @lcpr case=end
 * 
 */

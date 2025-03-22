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
        /*
         * 这里的target>0可以看做是递归的出口(实际是target递归到0时就直接返回0了)
         * 因为&&运算符前面是false的话后面就不会执行了
         * 那么&&右边的可以看做是实际的递归方法体
         */
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

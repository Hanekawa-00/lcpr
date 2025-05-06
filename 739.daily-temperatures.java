/*
 * @lc app=leetcode.cn id=739 lang=java
 * @lcpr version=30204
 *
 * [739] 每日温度
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Stack;

class Solution {
    /**
     * 使用单调栈来找到下一个更大的元素
     * 
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // 单调栈：维护一个“等待找到下一个更大元素”的元素的集合
        Stack<Integer> stack = new Stack<>();
        int curr;
        for (int i = 0; i < temperatures.length; i++) {
            curr = temperatures[i];
            // 对于当前元素，我们需要知道它之前哪些元素的“下一个更大元素”就是当前元素
            // 观察可得这个栈中的元素一直是单调递减的，这是因为在push之前都会把小的元素pop掉
            while (!stack.isEmpty() && temperatures[stack.peek()] < curr) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [73,74,75,71,69,72,76,73]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [30,40,50,60]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [30,60,90]\n
 * // @lcpr case=end
 * 
 */

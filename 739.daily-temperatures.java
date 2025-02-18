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
        int n = temperatures.length;
        int[] answer = new int[temperatures.length];
        // 这个栈用来保存日期
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currTemperature = temperatures[i];
            // 如果找到了一个高温天气，则进入循环将前面的低温天气的answer设置
            while (!stack.isEmpty()
                    && currTemperature > temperatures[stack.peek()]) {
                int topIndex = stack.pop();
                answer[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        return answer;
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

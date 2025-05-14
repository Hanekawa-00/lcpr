/*
 * @lc app=leetcode.cn id=LCR 148 lang=java
 * @lcpr version=30204
 *
 * [LCR 148] 验证图书取出顺序
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Stack;

class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int takeOutIndex = 0;
        for (int i = 0; i < putIn.length; i++) {
            stack.push(putIn[i]);
            while (!stack.isEmpty() && stack.peek() == takeOut[takeOutIndex]) {
                stack.pop();
                takeOutIndex++;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [6,7,8,9,10,11]\n[9,11,10,8,7,6]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [6,7,8,9,10,11]\n[11,9,8,10,6,7]\n
 * // @lcpr case=end
 * 
 */

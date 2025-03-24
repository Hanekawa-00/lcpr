/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30204
 *
 * [20] 有效的括号
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '('
                    || ch == '{'
                    || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (top == '(' && ch != ')'
                        || top == '{' && ch != '}'
                        || top == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "()"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "()[]{}"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "(]"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "([])"\n
 * // @lcpr case=end
 * 
 */

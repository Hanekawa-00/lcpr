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
        char[] chArr = s.toCharArray();
        for (char ch : chArr) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty()) {// 如果开始是右括号
                return false;
            } else if (ch == ')' && stack.peek() != '(') {
                return false;
            } else if (ch == '}' && stack.peek() != '{') {
                return false;
            } else if (ch == ']' && stack.peek() != '[') {
                return false;
            } else { // 成功匹配一对
                stack.pop();
            }
        }
        // 如果栈为空则全部匹配
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

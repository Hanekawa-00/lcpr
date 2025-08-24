/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30204
 *
 * [20] 有效的括号
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('
                    || ch == '['
                    || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                } else {
                    stack.pop();
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

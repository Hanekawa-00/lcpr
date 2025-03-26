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
        /*
         * 想象一下我们手动检查括号是否匹配的过程。当我们遇到一个左括号 (, {, [ 时，我们期望在后面的某个位置遇到一个对应的右括号 ), }, ]
         * 来与之匹配。
         * 
         * 关键在于“正确顺序”。比如 ([)] 就不是有效的，因为 ( 先出现，然后是 [，但 ] 却在 ) 之前闭合了 [，导致 ( 无法与 )
         * 匹配。这暗示了后出现的左括号需要先被闭合。
         * 
         * 这 “后进先出”（Last-In, First-Out, LIFO）的特性是不是让你想到了什么数据结构？
         * 
         * 没错！就是 栈（Stack）。
         * 
         */
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

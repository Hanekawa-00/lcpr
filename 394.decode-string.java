/*
 * @lc app=leetcode.cn id=394 lang=java
 * @lcpr version=30204
 *
 * [394] 字符串解码
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();// 当前[]中的字符串
        int currentNum = 0;// 当前层重复次数
        /*
         * 当遇到 [ 时，我们需要保存当前的状态（重复次数和已经构建的字符串），然后开始处理括号内的内容。当遇到 ]
         * 时，我们需要恢复之前的状态，并将括号内解码后的字符串重复相应次数，再拼接到之前的字符串上。
         */
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { // 处理数字
                // 因为可能是多位数字,故这里并不插入栈中
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // 重复次数入栈
                countStack.push(currentNum);
                // 外层字符串入栈
                stringStack.push(currentString);
                // 重置
                currentNum = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                int k = countStack.pop(); // 弹出当前层数
                StringBuilder preString = stringStack.pop();// 前一个字符串（可能为空串）
                // 将当前括号中字符串*k加到上一个字符串后面
                for (int i = 0; i < k; i++) {
                    preString.append(currentString);
                }
                currentString = preString;
            } else { // 处理普通字符
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "3[a]2[bc]"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "3[a2[c]]"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "2[abc]3[cd]ef"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abc3[cd]xyz"\n
 * // @lcpr case=end
 * 
 */

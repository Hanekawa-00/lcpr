/*
 * @lc app=leetcode.cn id=32 lang=java
 * @lcpr version=30204
 *
 * [32] 最长有效括号
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    int max = 0; // 返回结果

    public int longestValidParentheses(String s) {
        find(s, true, 0);
        return max;
    }

    private int find(String s, boolean isOrigin, int startIndex) {
        int count = 0; // 当前有效长度
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i); // 当前字符
            // 当前字符为正括号
            if (c == '(') {
                // 如果当前字符为最后一位，退出循环。
                if (i == s.length() - 1) {
                    break;
                }
                // 如果下一位字符仍是正括号
                if (s.charAt(i + 1) == '(') {
                    // 从下一位开始递归嵌套子字符串，取得其有效长度
                    int childCount = find(s, false, i + 1);
                    // 如果有效长度为0，则结束循环。
                    // 注意，因为当前字符及下一位字符均为正括号，childCount为0只有一种可能
                    // 即是，当前位置到字符串结尾均为正括号，所以可以结束循环。
                    if (childCount == 0) {
                        break;
                    }
                    // childCount大于0，且长度为childCount的嵌套子串被正括号与反括号包围
                    if (i + childCount + 1 < s.length() && s.charAt(i + childCount + 1) == ')') {
                        // 有效长度应为原有效长度 + childCount + 2
                        count += (childCount + 2);
                    } else {
                        break;
                    }
                    // index跳过有效嵌套子串长度加一，继续循环。
                    i += (childCount + 1);
                } else {
                    // 如果下一位字符为反括号，则找到一组括号对，count加2
                    count += 2;
                    // 跳过下一位的反括号继续循环
                    i += 1;
                }
            } else {
                // [else]当前字符为反括号的情况。
                // 如果是原始字符
                if (isOrigin) {
                    // 清算当前长度后继续循环。
                    max = Math.max(count, max);
                    count = 0;
                } else {
                    // 如果是嵌套子串，说明有效子串结束，退出循环
                    break;
                }
            }
        }
        max = Math.max(count, max);
        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "(()"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ")()())"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ""\n
 * // @lcpr case=end
 * 
 */

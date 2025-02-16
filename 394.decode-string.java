/*
 * @lc app=leetcode.cn id=394 lang=java
 * @lcpr version=30204
 *
 * [394] 字符串解码
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char curr = s.charAt(index);
            if (Character.isDigit(curr)) {
                int repeatTimes = 0;
                while (Character.isDigit(s.charAt(index))) {
                    repeatTimes = repeatTimes * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++;
                int brackCount = 1;
                int startIndex = index;
                while (index < s.length()) {
                    if (s.charAt(index) == '[') {
                        brackCount++;
                    } else if (s.charAt(index) == ']') {
                        brackCount--;
                        if (brackCount == 0) {
                            break;
                        }
                    }
                    index++;
                }
                String encodeString = s.substring(startIndex, index);
                String decodeString = decodeString(encodeString);// 递归解码
                for (int i = 0; i < repeatTimes; i++) {
                    res.append(decodeString);
                }
                index++;
            } else if (Character.isLetter(curr)) {
                res.append(curr);
                index++;
            }
        }
        return res.toString();
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

/*
 * @lc app=leetcode.cn id=LCR 181 lang=java
 * @lcpr version=
 *
 * [LCR 181] 字符串中的单词反转
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String reverseMessage(String message) {
        // 处理多个连续空格的情况
        String[] words = message.trim().split("\\s+"); 
        StringBuilder result = new StringBuilder();
        
        // 从后向前遍历单词数组
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "the sky is blue"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "  hello world!  "\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a good   example"\n
 * // @lcpr case=end
 * 
 */

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
        if (message == null) {
            return ""; // 或者根据题目要求处理null，通常返回空字符串
        }
        
        StringBuilder sb = new StringBuilder();
        int right = message.length() - 1;
        
        while (right >= 0) {
            // 1. 跳过当前单词（从右往左看是下一个单词）之后的空格
            while (right >= 0 && message.charAt(right) == ' ') {
                right--;
            }
            
            if (right < 0) { // 如果right < 0，说明剩下的都是空格或字符串已处理完
                break;
            }
            
            // 2. 找到当前单词的结束位置（从右往左看）
            int wordEnd = right;
            
            // 3. 找到当前单词的开始位置（从右往左看）
            while (right >= 0 && message.charAt(right) != ' ') {
                right--;
            }
            // 单词的实际开始索引是 right + 1
            
            // 4. 提取单词
            String word = message.substring(right + 1, wordEnd + 1);
            
            // 5. 拼接到结果字符串
            if (sb.length() > 0) {
                sb.append(" "); // 在单词前添加空格（除了第一个单词）
            }
            sb.append(word);
        }
        
        return sb.toString();
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

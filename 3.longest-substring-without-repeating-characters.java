/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start


class Solution {
    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> charSet = new HashSet<>();
        // 左指针
        int left = 0;
        // 最长无重复字符子串的长度
        int maxLength = 0;
        // 右指针
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果字符已经出现过，则移动左指针，直到窗口中不再包含重复字符（这个窗口已经不能移动了，所以要创建新窗口）
            while (charSet.contains(c)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // 将当前字符加入哈希集合
            charSet.add(c);
            // 更新最长无重复字符子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abcabcbb"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "bbbbb"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "pwwkew"\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = left;
        Set<Character> set = new HashSet<>();
        int res = 1;
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (set.contains(curr)) {
                res = Math.max(res, right - left);
                while (set.contains(curr)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            right++;
        }
        res = Math.max(right - left, res);
        return res;
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

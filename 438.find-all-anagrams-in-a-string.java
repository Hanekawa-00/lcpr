/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30204
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        int[] map = new int[26];
        for (char ch : p.toCharArray()) {
            map[ch - 'a']++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (map[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            map[s.charAt(right) - 'a']--;
            right++;

            if (count == 0) {
                ans.add(left);
            }

            if (right - left == p.length()) {
                if (map[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                map[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return ans;
    }

   
}


// @lc code=end

/*
 * // @lcpr case=start
 * // "cbaebabacd"\n"abc"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abab"\n"ab"\n
 * // @lcpr case=end
 * 
 */

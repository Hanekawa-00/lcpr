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

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 1;
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        while (true) {
            while (right < arr.length && !set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            }
            int curr = right - left;
            result = Math.max(curr, result);
            if (right >= arr.length) {
                break;
            } else {
                while (set.contains(arr[right])) {
                    set.remove(arr[left]);
                    left++;
                }
            }
        }
        return result;
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

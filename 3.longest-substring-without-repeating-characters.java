/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int left = 0;
        // 使用哈希来优化，可以达到跳跃索引的效果
        Map<Character, Integer> map = new HashMap<>();
        // 同样是移动right指针
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            // 窗口中存在curr
            if (map.containsKey(curr)) {
                // 更新左边界为那个重复的key的右边，使用哈希快速跳转而不是逐个遍历
                left = Math.max(left, map.get(curr) + 1);
            }
            // 添加索引
            map.put(curr, right);
            // 更新max
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

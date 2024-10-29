/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * @see https://flowus.cn/hanekawa/f12b06b1-4611-443a-bb1c-3a52302b69d4
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 最多又可能有256个字符 0——255
        int[] lastIndex = new int[256];
        // 初始化每个字符的索引为-1
        Arrays.fill(lastIndex, -1);
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            // 3. l向右移(对应字符靠r的移动来维护，如果在r的移动过程中中含有重复字符，则l要跳到重复字符的后面)
            l = Math.max(l, lastIndex[s.charAt(r)] + 1);
            // 1.
            ans = Math.max(ans, r - l + 1);
            // 2.记录上一次字符出现的位置
            lastIndex[s.charAt(r)] = r;
        }
        return ans;
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

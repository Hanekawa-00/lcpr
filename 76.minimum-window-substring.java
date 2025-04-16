/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30204
 *
 * [76] 最小覆盖子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int[] need = new int[128]; // 统计每个字符出现的次数
        int[] window = new int[128];// 统计窗口中目标字符的数量
        int tLen = t.length(); // 目标字符串长度
        // 统计需求量
        for (int i = 0; i < tLen; i++) {
            need[t.charAt(i)]++;
        }
        int needCnt = 0; // 记录需要字符的种类数量
        for (int count : need) {
            if (count > 0) {
                needCnt++;
            }
        }
        int left = 0; // 窗口左边界
        int right = 0;
        int vaildCount = 0; // 窗口中已经满足条件的字符种类数量
        int sLen = s.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        while (right < sLen) {
            char charRight = s.charAt(right);
            right++;
            if (need[charRight] > 0) {
                window[charRight]++; // 统计数加一
                if (window[charRight] == need[charRight]) {
                    vaildCount++;
                }
            }
            // 尝试缩小窗口
            while (vaildCount == needCnt) {
                // 更新最小窗口参数
                if (right - left < minLen) {
                    minStart = left;
                    minLen = right - left;
                }
                // 左指针右移
                char charLeft = s.charAt(left);
                left++;
                // 如果是需要的字符，那么要更新vailCount和window[charLeft]
                if (need[charLeft] > 0) {
                    if (window[charLeft] == need[charLeft]) {
                        vaildCount--;
                    }
                    window[charLeft]--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "ADOBECODEBANC"\n"ABC"\n
 * // @lcpr case=end
 *
 * // @lcpr case=start
 * // "a"\n"a"\n
 * // @lcpr case=end
 *
 * // @lcpr case=start
 * // "a"\n"aa"\n
 * // @lcpr case=end
 *
 */

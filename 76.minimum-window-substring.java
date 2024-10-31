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
        // 如果字符串长度小于目标则直接返回空
        if (s.length() < t.length()) {
            return "";
        }
        // 用来记录所有字符的情况 ，若目标含有 n个，则设置为-n
        int[] cnts = new int[256];
        for (char ch : t.toCharArray()) {
            cnts[ch]--;
        }
        int len = Integer.MAX_VALUE;
        int start = 0;// 因为是返回子串，所以记录子串起始位置
        // debt为目标长度
        for (int l = 0, r = 0, debt = t.length(); r < s.length(); r++) {
            if (cnts[s.charAt(r)]++ < 0) {// 小于零就说明是目标中的字符串
                debt--;
            }
            // 当包含全部目标时
            if (debt == 0) {
                // 大于0就说明是多于的，直接去掉（索引向右）
                while (cnts[s.charAt(l)] > 0) {
                    cnts[s.charAt(l++)]--;
                }
                // 计算len
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        // 关于为什么一次性就能找到最小字串：因为r走过整个字符串，遍历了所有字符
        // 输入：s = "ADOBECODEBANC", t = "ABC"
        // 输出："BANC"
        // 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
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

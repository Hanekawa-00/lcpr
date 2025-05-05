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
import java.util.Arrays; // 需要导入 Arrays 用于比较数组
import java.util.List;
// 移除了未使用的 Map 导入

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        // 如果 p 比 s 长，不可能找到异位词
        if (pLen > sLen) {
            return res;
        }

        // 1. 创建频率数组
        int[] pFreq = new int[26]; // 存储 p 中字符的频率
        int[] windowFreq = new int[26]; // 存储当前窗口中字符的频率

        // 2. 计算 p 的频率 和 初始化第一个窗口的频率
        for (int i = 0; i < pLen; i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        // 3. 检查第一个窗口是否是异位词
        if (Arrays.equals(pFreq, windowFreq)) {
            res.add(0);
        }

        // 4. 滑动窗口
        // left 指向窗口的起始位置，right 指向窗口的结束位置的下一个位置
        // 窗口范围是 [left, right - 1]
        for (int i = pLen; i < sLen; i++) {
            // 窗口向右滑动：
            // 移出窗口的字符 (最左边的字符)
            windowFreq[s.charAt(i - pLen) - 'a']--;
            // 加入窗口的字符 (新进入的最右边的字符)
            windowFreq[s.charAt(i) - 'a']++;

            // 5. 检查当前窗口是否是异位词
            if (Arrays.equals(pFreq, windowFreq)) {
                // 如果是，添加窗口的起始索引 (i - pLen + 1)
                res.add(i - pLen + 1);
            }
        }
        return res;
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

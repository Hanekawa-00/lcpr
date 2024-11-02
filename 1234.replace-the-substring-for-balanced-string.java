/*
 * @lc app=leetcode.cn id=1234 lang=java
 * @lcpr version=30204
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    /**
     * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
     * 
     * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
     * 
     * 
     * 
     * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
     * 
     * @param s
     * @return 请返回待替换子串的最小可能长度。
     */
    public int balancedString(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('Q', 0);
        hashMap.put('W', 0);
        hashMap.put('E', 0);
        hashMap.put('R', 0);
        // 记录出现次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        // 记录需要去除的各个字符的个数
        int dept = 0;
        for (Character key : hashMap.keySet()) {
            if (hashMap.get(key) > s.length() / 4) {
                dept += hashMap.get(key) - s.length() / 4;
                hashMap.put(key, hashMap.get(key) - s.length() / 4);
            } else {
                hashMap.put(key, 0);// 题目只要求返回需要替换的字符串长度，所以只要记录需要替换的字符就可以，其他一律置零
            }
        }

        if (dept == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;

        while (r < s.length()) {
            char current = s.charAt(r);
            if (hashMap.get(current) > 0) {// 说明这个字符是多余的（即这个字符的数量大于s.length() / 4）
                dept--;// dept--是因为将多余的字符包含在窗口中了（这个子串要被替换）
            }
            hashMap.put(current, hashMap.get(current) - 1);// 既然这个字符将要被替换，那么减少原记录
            r++;
            // dept==0 说明已经找到了所有多余字符组成的窗口，但有可能不是最短
            while (dept == 0) {// 自循,在这个情况下的窗口
                ans = Math.min(ans, r - l);
                char leftChar = s.charAt(l);
                hashMap.put(leftChar, hashMap.get(leftChar) + 1);//看第62行
                if (hashMap.get(leftChar) > 0) {
                    dept++;
                }
                l++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // "QWER"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "QQWE"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "QQQW"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "QQQQ"\n
 * // @lcpr case=end
 * 
 */

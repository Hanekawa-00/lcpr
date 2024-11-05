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
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();//用来维护目标数量
        char[] charArray = p.toCharArray();
        for (char ch : charArray) {//初始化
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int dept = p.length();//记录子串个数
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {//说明需求并未达到
                    dept--;
                }
            }
            while (dept == 0) {
                if (r - l + 1 == p.length()) {
                    ans.add(l);
                }
                char leftChar = s.charAt(l);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        dept++;
                    }
                }
                l++;
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

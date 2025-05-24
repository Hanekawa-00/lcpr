/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(map, digits, new StringBuilder(), 0);
        return res;
    }

    private void backtrack(Map<Character, String> map, String digits, StringBuilder path, int index) {
        if (index >= digits.length()) {
            res.add(path.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backtrack(map, digits, path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // "23"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ""\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "2"\n
 * // @lcpr case=end
 * 
 */

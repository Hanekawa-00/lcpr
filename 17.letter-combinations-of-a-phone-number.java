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
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
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
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * @param combinations 结果集
     * @param phoneMap     映射关系
     * @param digits       输入的数字
     * @param index        输入数字遍历到的索引
     * @param combination
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
            StringBuffer combination) {
        // 完成
        if (index == digits.length()) {
            // 添加到结果集
            combinations.add(combination.toString());
        } else {
            // 提取数字
            char digit = digits.charAt(index);
            // 获取映射结果
            String letters = phoneMap.get(digit);
            // 并非所有数字的映射都是三个字符
            int lettersCount = letters.length();
            // 每个index都有所在位置数字所映射的字符的所有可能
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
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

/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30204
 *
 * [49] 字母异位词分组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(strs[0]);
            res.add(list);
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // 排序字符
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // 使用hash进行分组
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        for (List<String> valueList : map.values()) {
            res.add(valueList);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // ["eat", "tea", "tan", "ate", "nat", "bat"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [""]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["a"]\n
 * // @lcpr case=end
 * 
 */

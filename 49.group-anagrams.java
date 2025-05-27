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
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            // 如果不存在就创建并返回value值，否则直接返回已经存在的value
            map.computeIfAbsent(key,k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
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

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
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortKey = new String(charArray);
            if (map.containsKey(sortKey)) {
                map.get(sortKey).add(str);
            } else {
                map.put(sortKey, new ArrayList<String>());// 这里重复put会覆盖原来的value值，故用if
                map.get(sortKey).add(str);
            }
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

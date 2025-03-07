/*
 * @lc app=leetcode.cn id=LCR 169 lang=java
 * @lcpr version=30204
 *
 * [LCR 169] 招式拆解 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Solution {
    public char dismantlingAction(String arr) {
        // 有序哈希表
        LinkedHashMap<Character, Boolean> linkedHashMap = new LinkedHashMap<Character, Boolean>();
        char[] charArray = arr.toCharArray();
        for (char ch : charArray) {
            // 我们只注意两种状态，出现过一次，出现过多次
            linkedHashMap.put(ch, linkedHashMap.containsKey(ch));
        }
        for (Entry<Character, Boolean> entry : linkedHashMap.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abbccdeff"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "ccdd"\n
 * // @lcpr case=end
 * 
 */

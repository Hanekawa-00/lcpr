/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30204
 *
 * [139] 单词拆分
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.List;

class Solution {
    private HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                boolean flag = false;
                String sub = s.substring(word.length());
                if (memo.containsKey(sub)) {
                    flag = memo.get(sub);
                } else {
                    flag = wordBreak(sub, wordDict);
                    memo.put(sub, flag);
                }
                if (flag == true) {
                    return true;
                }
            }
        }
        return false;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // "leetcode"\n["leet", "code"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "applepenapple"\n["apple", "pen"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "catsandog"\n["cats", "dog", "sand", "and", "cat"]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30204
 *
 * [139] 单词拆分
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        // dp[i] 维护前i个字符([0,i])组成的单词是否可以被拆分
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            // [0,i]有可能被分为[0,j][j,i]即可以被拆分(当然也包含了它本甚就是一个单词)
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
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

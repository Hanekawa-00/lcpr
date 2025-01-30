/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30204
 *
 * [139] 单词拆分
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 定义 dp 数组，dp[i] 表示 s[0:i] 是否可以被拼接,0表示空字符
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 空字符串可以被拼接
        // 遍历字符串的每个位置
        for (int i = 1; i <= s.length(); i++) {
            // 检查从 j 到 i 的子串是否在字典中
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // 找到一种拆分方式即可停止内层循环
                }
            }
        }
        // 返回整个字符串是否可以被拼接
        return dp[s.length()];
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

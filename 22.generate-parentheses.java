/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30204
 *
 * [22] 括号生成
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxPairs;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        this.maxPairs = n;
        this.res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0);
        return res;
    }

    private void backtrack(StringBuilder currString, int leftCount, int rightCount) {
        if (currString.length() == maxPairs * 2) {
            res.add(currString.toString());
            return;
        }
        // 每次有两种选择，这里可以直接使用两次if优化
        char[] options = new char[] { '(', ')' };
        for (char option : options) {
            if (option == '(') {
                // 左括号的限制是小于括号对数
                if (leftCount == maxPairs) {
                    continue;
                } else {
                    currString.append(option);
                    backtrack(currString, leftCount + 1, rightCount);
                }
            } else {
                // 右括号的限制是必须小于左括号数量(还有要小于总对数，因为上面的left已有限制，所以可以省略)，这里因为要++，所以一定要小于左括号数量
                if (rightCount >= leftCount) {
                    continue;
                } else {
                    currString.append(option);
                    backtrack(currString, leftCount, rightCount + 1);
                }
            }
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */

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
    List<String> pairs;
    String path;

    public List<String> generateParenthesis(int n) {
        path = "()";
        pairs = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder());
        return pairs;
    }

    private void backtrack(int n, int leftNums, int rightNums, StringBuilder sb) {
        if (rightNums == n) {
            pairs.add(sb.toString());
            return;
        }
        // 关键-> rightNums <= leftNums <= n
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == ')') {
                if (rightNums < leftNums) {
                    sb.append(path.charAt(i));
                    backtrack(n, leftNums, rightNums + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                if (leftNums < n) {
                    sb.append(path.charAt(i));
                    backtrack(n, leftNums + 1, rightNums, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
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

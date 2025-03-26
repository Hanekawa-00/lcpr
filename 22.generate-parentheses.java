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
    private List<String> result;

    private int targetN;

    /**
     * 一共有n对括号（左右都为n）
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        this.targetN = n;
        this.result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0);
        return result;
    }

    private void backtrack(StringBuilder str, int openCount, int closeCount) {
        // 递归退出
        if (openCount == targetN && closeCount == targetN) {
            result.add(str.toString());
            return;
        }
        // 以下过程就相当于回溯的的过程
        // 一共两个路径，在路径多的情况下，一般使用for循环加if判断
        if (openCount < targetN) {
            str.append('(');
            backtrack(str, openCount + 1, closeCount);
            str.deleteCharAt(str.length() - 1);
        }
        // 闭括号数量要严格小于开括号数量
        if (closeCount < openCount) {
            str.append(')');
            backtrack(str, openCount, closeCount + 1);
            str.deleteCharAt(str.length() - 1);
        }
        return;
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

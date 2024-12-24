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
    /**
     * 一共有n对括号（左右都为n）
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }

    /**
     * @param result 结果
     * @param current 当前串
     * @param left 缺少的左括号数
     * @param right 缺少的右括号数
     */
    private void backtrack(List<String> result, String current, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        if (left > 0) {
            backtrack(result, current + "(", left - 1, right);
        }
        if (right > left) {
            backtrack(result, current + ")", left, right - 1);
        }
    }
//   决策树：
//                                          ""(left=3,right=3)
//                                          /
//                                     "("(2,3) 
//                                     /        \
//                               "(("(1,3)      "()"(2,2)
//                               /      \         /      \
//                         "((("(0,3)  "(()"(1,2) "()("(1,2)  
//                             |           /           \
//                       "((())"(0,2)  "(()("(0,2)   "()(("(0,2)
//                             |           |              |
//                       "((()))"(0,1)  "(())()"(0,1)  "()(()"(0,1)
//                             |           |              |
//                       "((()))"(0,0)  "(()())"(0,0)  "()(())"(0,0)
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

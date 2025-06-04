/*
 * @lc app=leetcode.cn id=118 lang=java
 * @lcpr version=30204
 *
 * [118] 杨辉三角
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>() {
            {
                add(1);
            }
        };
        res.add(firstRow);
        List<Integer> pre = firstRow;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i - 1; j++) {
                curr.add(pre.get(j - 1) + pre.get(j));
            }
            curr.add(1);
            pre = curr;
            res.add(curr);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */

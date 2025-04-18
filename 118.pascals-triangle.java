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
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>(numRows);
        // 完成第一行
        List<Integer> firstRow = new ArrayList<>(1);
        firstRow.add(1);
        resList.add(firstRow);
        // 从第二行开始
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = resList.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(preRow.get(j - 1) + preRow.get(j));
            }
            currRow.add(1);
            resList.add(currRow);
        }
        return resList;
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

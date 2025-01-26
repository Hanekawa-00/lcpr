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
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        // 添加第一行
        res.add(new ArrayList<>());
        res.get(0).add(1);
        // 从第二行开始生成
        for (int row = 2; row <= numRows; row++) {
            List<Integer> current = new ArrayList<>();
            res.add(current);
            generateRow(row, res);
        }
        return res;
    }

    private void generateRow(int currRow, List<List<Integer>> res) {
        List<Integer> prev = res.get(currRow - 2); // 前一行
        List<Integer> curr = res.get(currRow - 1); // 当前行
        int currLength = currRow;
        curr.add(1); // 添加首元素
        // 中间元素,从第二个开始添加，添加到倒数第二个元素
        for (int i = 1; i < currLength - 1; i++) {
            curr.add(prev.get(i - 1) + prev.get(i));
        }
        // 尾元素
        curr.add(1);

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

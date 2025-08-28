/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30204
 *
 * [39] 组合总和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void backtrack(int[] candidates, List<Integer> path, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 从索引 index 开始搜索，避免重复组合的产生，同时支持同一元素重复使用
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 这里传入的是i，到下一层仍然可以重复使用i
            backtrack(candidates, path, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,6,7]\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,5]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2]\n1\n
 * // @lcpr case=end
 * 
 */

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
        backtrack(new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private void backtrack(List<Integer> path, int index, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 因为允许重复选择某个元素，所以传入i
            backtrack(path, i, candidates, target - candidates[i]);
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

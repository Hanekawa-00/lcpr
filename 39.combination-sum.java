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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // Arrays.sort(candidates); // 可选，排序以便剪枝
        backtrack(res, path, candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue; // 可剪枝，当前元素大于目标值，直接跳过
            }
            path.add(candidates[i]); // 选择当前元素
            // zhu'r
            backtrack(res, path, candidates, target - candidates[i], i); // 递归，i 不变，允许重复选择
            path.remove(path.size() - 1); // 取消选择，回溯
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

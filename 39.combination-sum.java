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
        backtrack(candidates, new ArrayList<>(), target, 0);
        return res;
    }

    private void backtrack(int[] candidates, List<Integer> path, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 一个元素可以被多次选中，所以传入i
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

/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30204
 *
 * [46] 全排列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path) {
        if (path.size() >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backtrack(nums, path);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */

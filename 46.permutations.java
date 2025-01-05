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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (nums.length == 1) {
            path.add(nums[0]);
            res.add(path);
            return res;
        }
        backtrack(nums, res, path);
        return res;
    }

    /**
     * @param nums 源数组
     * @param res  最终结果集
     * @param path 路径
     */
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, res, path);
            path.remove(path.size() - 1);// 退步，回溯，进入下一条路径
        }
        return;
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

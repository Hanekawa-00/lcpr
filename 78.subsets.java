/*
 * @lc app=leetcode.cn id=78 lang=java
 * @lcpr version=30204
 *
 * [78] 子集
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), res, 0, nums);
        return res;
    }

    private void backtrack(List<Integer> path, List<List<Integer>> res, int startIndex, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(path, res, i + 1, nums);
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
 * // [0]\n
 * // @lcpr case=end
 * 
 */

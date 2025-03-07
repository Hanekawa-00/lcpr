/*
 * @lc app=leetcode.cn id=LCR 153 lang=java
 * @lcpr version=30204
 *
 * [LCR 153] 二叉树中和为目标值的路径
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(TreeNode root, int target, int curr, List<Integer> item, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        curr += root.val;
        item.add(root.val);
        // 处理叶子节点
        if (root.left == null && root.right == null) {
            // 注意这里题目要求的是到叶子节点的和
            if (curr == target) {
                res.add(new ArrayList<>(item));
            }
            // 虽然得到结果但是要把每个路径都要尝试一下，这里仍然需要回溯
            item.remove(item.size() - 1);
            return;
        }
        backtrack(root.left, target, curr, item, res);
        backtrack(root.right, target, curr, item, res);
        // 回溯到上一层（上一个节点）状态
        item.remove(item.size() - 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n0\n
 * // @lcpr case=end
 * 
 */

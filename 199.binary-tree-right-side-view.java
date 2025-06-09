/*
 * @lc app=leetcode.cn id=199 lang=java
 * @lcpr version=30204
 *
 * [199] 二叉树的右视图
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
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
    private List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, new HashSet<>(), 0);
        return res;
    }

    private void dfs(TreeNode root, Set<Integer> set, int deepth) {
        if (root == null) {
            return;
        }
        if (!set.contains(deepth)) {
            res.add(root.val);
            set.add(deepth);
        }
        dfs(root.right, set, deepth + 1);
        dfs(root.left, set, deepth + 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,null,5,null,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,null,null,null,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,null,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */

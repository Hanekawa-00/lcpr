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
        this.res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        rightSideViewHelper(root, 0);
        return res;
    }

    private void rightSideViewHelper(TreeNode root, int deepth) {
        if (root == null) {
            return;
        }
        // 如果当前深度deepth在 res 中还没有元素，说明这是当前深度的最右节点 (因为我们先遍历右子树)
        if (res.size() == deepth) {
            res.add(root.val);
        }
        // 优先遍历right子树，保证right的节点先被访问到
        rightSideViewHelper(root.right, deepth + 1);
        rightSideViewHelper(root.left, deepth + 1);
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

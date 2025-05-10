/*
 * @lc app=leetcode.cn id=LCR 144 lang=java
 * @lcpr version=30204
 *
 * [LCR 144] 翻转二叉树
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
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
    public TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flipTree(left);
        flipTree(right);
        root.left = right;
        root.right = left;
        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,7,9,8,3,2,4]\n
 * // @lcpr case=end
 * 
 */

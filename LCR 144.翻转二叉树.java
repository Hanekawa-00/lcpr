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
        // 交换已经交换完成的子树
        TreeNode tmp = root.left;
        // left节点与翻转后的右子树交换
        root.left = flipTree(root.right);
        // right节点与翻转后的左子树（其实现在这个子树已经断掉了，tmp用来暂存左节点）
        root.right = flipTree(tmp);
        // 将翻转后的根节点返回
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

/*
 * @lc app=leetcode.cn id=LCR 176 lang=java
 * @lcpr version=30204
 *
 * [LCR 176] 判断是否为平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        // 二叉树中'任意'节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
        if (root == null) {
            return true;
        }
        int leftHeght = getHeight(root.left);
        int rightHeght = getHeight(root.right);
        int diff = leftHeght > rightHeght ? leftHeght - rightHeght : rightHeght - leftHeght;
        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2,3,3,null,null,4,4]\n
 * // @lcpr case=end
 * 
 */

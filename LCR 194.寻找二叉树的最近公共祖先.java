/*
 * @lc app=leetcode.cn id=LCR 194 lang=java
 * @lcpr version=30204
 *
 * [LCR 194] 二叉树的最近公共祖先
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
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 尝试去子树寻找
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if (leftLCA != null && rightLCA != null) {
            // 分别在左右子树
            return root;
        } else if (leftLCA != null) {
            // 只在其中一个子树，并且找到了p或者q
            return leftLCA;
        } else if (rightLCA != null) {
            return rightLCA;
        } 
        //按理说不会执行到这
        return null;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
 * // @lcpr case=end
 * 
 */

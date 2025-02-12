/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30204
 *
 * [236] 二叉树的最近公共祖先
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

    /**
     * 使用中序遍历，先遍历左右子树，找到目标节点就直接向上回溯
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 递归到最底层
        if (root == null) {
            return root;
        }
        // 找到目标节点
        if (root == p || root == q) {
            return root;
        }
        // 中序遍历
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        // 中
        // 找到两个节点后返回根节点
        if (left != null && right != null) {
            return root;
        }
        // 只找到其中之一，则向上回溯
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
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
 * // @lcpr case=start
 * // [1,2]\n1\n2\n
 * // @lcpr case=end
 * 
 */

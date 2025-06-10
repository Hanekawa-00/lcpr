/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30204
 *
 * [236] 二叉树的最近公共祖先
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.PriorityQueue;

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
        // 找到其中之一，另外一个可能在另一个子树上，或者在当前节点的子树
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // 说明在两个子树上，当前root只能是最近公共祖先
        if (leftNode != null && rightNode != null) {
            return root;
        }
        // 在一棵子树的情况，可能是上层递归而来（上层是在两颗子树上，然后把公共祖先返回了）
        return leftNode == null ? rightNode : leftNode;
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

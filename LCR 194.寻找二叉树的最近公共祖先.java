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
         // 递归终止条件：当前节点为 null 或找到 p 或 q
         if (root == null || root == p || root == q) {
            return root;
        }
        
        // 递归遍历左子树和右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 如果左右子树均不为空，当前节点为 LCA
        if (left != null && right != null) {
            return root;
        }
        // 若只有其中之一为空，说明两个目标节点都在另一个子树上
        // 否则返回非空的子树结果，若都为空则返回 null
        return left != null ? left : right;
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

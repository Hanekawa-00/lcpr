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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历到底或者找到目标节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 尝试去左右子树分别寻找目标节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /*
         * 有三种情况：
         * 1.分别在左右子树，又因为是深度遍历，所以当前节点root肯定是最近的祖先节点，然后返回到上一层，然后就变成第二种情况了
         * 2.两个节点都在在一颗子树上，说明这个节点（left或者right，不一定是根节点，因为是上一层返回的）是上一层返回的结果，如此一直向上递归
         * 3.只找到一个目标节点，说明当前子树只存在一个节点，直接向上递归返回
         */
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
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

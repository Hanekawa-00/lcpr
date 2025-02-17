/*
 * @lc app=leetcode.cn id=543 lang=java
 * @lcpr version=30204
 *
 * [543] 二叉树的直径
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
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dep(root);
        return ans - 1;
    }

    private int dep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int L = dep(node.left);
        int R = dep(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n
 * // @lcpr case=end
 * 
 */

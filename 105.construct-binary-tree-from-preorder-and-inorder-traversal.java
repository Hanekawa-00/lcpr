/*
 * @lc app=leetcode.cn id=105 lang=java
 * @lcpr version=30204
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = helpBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helpBuildTree(int[] preorder, int[] inorder, int preI, int preJ, int inI, int inJ) {
        if (inI > inJ || preI > preJ) {
            return null;
        }
        // 前序遍历的第一个值为rootVal
        int rootVal = preorder[preI];
        // 构建根结点
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inI;
        int leftTreeCount = 0;
        for (int i = inI; i <= inJ; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
                leftTreeCount = i - inI;
                break;
            }
        }
        TreeNode leftTree = helpBuildTree(preorder, inorder, preI + 1, preI + leftTreeCount, inI, inRootIndex - 1);
        TreeNode rightTree = helpBuildTree(preorder, inorder, preI + leftTreeCount + 1, preJ, inRootIndex + 1, inJ);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,15,7]\n[9,3,15,20,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */

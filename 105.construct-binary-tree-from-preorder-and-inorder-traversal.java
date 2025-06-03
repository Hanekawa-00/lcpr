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
        return helpBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helpBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int leftInSubEnd = inLeft, rightInSubStart = leftInSubEnd + 2;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                leftInSubEnd = i - 1;
                rightInSubStart = i + 1;
                break;
            }
        }
        int leftSubCount = leftInSubEnd - inLeft + 1;
        int leftPreSubEnd = preLeft + leftSubCount;
        int rightPreSubStart = leftPreSubEnd + 1;
        root.left = helpBuildTree(preorder, inorder, preLeft + 1, leftPreSubEnd, inLeft, leftInSubEnd);
        root.right = helpBuildTree(preorder, inorder, rightPreSubStart, preRight, rightInSubStart, inRight);
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

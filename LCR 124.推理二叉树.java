/*
 * @lc app=leetcode.cn id=LCR 124 lang=java
 * @lcpr version=30204
 *
 * [LCR 124] 推理二叉树
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
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preI, int preJ, int inI, int inJ) {
        if (preI > preJ || inI > inJ) { // 越界则返回null
            return null;
        }
        int rootVal = preorder[preI];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inI;
        int subLeftLength = 0;
        for (int i = inI; i <= inJ; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
                subLeftLength = i - inI;
                break;
            }
        }
        root.left = build(preorder, inorder, preI + 1, preI + subLeftLength, inI, inRootIndex - 1);
        root.right = build(preorder, inorder, preI + subLeftLength + 1, preJ, inRootIndex + 1, inJ);
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

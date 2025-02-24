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
        int n = preorder.length;
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * @param preorder
     * @param inorder
     * @param preStartIndex 前序遍历索引区间起始索引
     * @param preEndIndex
     * @param inStartIndex  中序遍历区间起始索引
     * @param inEndIndex
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder, int preStartIndex, int preEndIndex, int inStartIndex,
            int inEndIndex) {
        if (preStartIndex > preEndIndex) {
            return null;
        }
        // 前序遍历是：根左右，所以该子树的root为前序遍历的首个值
        int rootVal = preorder[preStartIndex];
        TreeNode root = new TreeNode(rootVal);
        // 左子树节点个数
        int leftSize = 0;
        // 统计左子树数目
        for (int i = inStartIndex; i < inorder.length; i++) {
            // 中序遍历是左根右，即左子树，根节点，右子树
            if (inorder[i] == rootVal) {
                break;
            }
            leftSize++;
        }
        // 递归构建左子树区间为preorder[当前root节点位置所应+1,当前位置索引+左子树大小]inorder[依然是inStartIndex,+左子树大小]
        root.left = build(preorder, inorder, preStartIndex + 1, preStartIndex + leftSize, inStartIndex,
                inStartIndex + leftSize);
        // 递归构建右子树
        root.right = build(preorder, inorder, preStartIndex + leftSize + 1, preEndIndex, inStartIndex + leftSize + 1,
                inEndIndex);
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

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
        int n = preorder.length;
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 前序遍历的遍历顺序是根节点+左子树+右子树（其中左右子树的遍历方式相同）
     * 中序遍历的遍历顺序是左子树+根节点+右子树
     * 由此我们可以知道preStartIndex所在位置是根节点，在根据这个值能够在中序遍历中找到根节点索引从而划分出左右子树的区间
     * 然后根据这两个区间的大小可以得到在前序遍历中的左右子树所在区间
     * 由此分别递归左右区间得到左右子树
     * 
     * @param preorder      前序遍历元数组
     * @param inorder       中序遍历元数组
     * @param preStartIndex 前序遍历的子区间start
     * @param preEndIndex
     * @param inStartIndex
     * @param inEndIndex
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder, int preStartIndex, int preEndIndex, int inStartIndex,
            int inEndIndex) {
        if (preStartIndex > preEndIndex) {
            return null;
        }
        // 根节点是前序遍历（根左右）第一个元素
        int rootVal = preorder[preStartIndex];
        TreeNode root = new TreeNode(rootVal);
        // 计算出左子树区间大小
        int leftSize = 0;
        for (int i = inStartIndex; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            leftSize++;
        }
        // 构建左子树
        root.left = build(preorder, inorder, preStartIndex + 1, preStartIndex + leftSize, inStartIndex,
                inStartIndex + leftSize);
        // 构建右子树
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

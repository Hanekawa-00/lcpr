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
    private int maxDiameter = 0;  // 全局变量，用于存储最大直径

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;  // 边界条件：空树，返回 0
        }
        calculateDepth(root);  // 启动递归计算
        return maxDiameter;    // 返回全局最大直径
    }

    private int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;  // 递归基：空节点，返回 0
        }
        // 递归计算左子树的深度
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        // 更新全局最大直径：通过当前节点的路径长度是 leftDepth + rightDepth
        // 注意这里的最大路径不一定是以原二叉树的根结点为路径，子树中可能存在更长的路径
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        // 深度+1（指当前节点的这层）
        return Math.max(leftDepth, rightDepth) + 1;
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

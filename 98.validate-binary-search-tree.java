/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30204
 *
 * [98] 验证二叉搜索树
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
    // 主方法，使用初始边界值开始BST验证
    public boolean isValidBST(TreeNode root) {
        // 使用整个long值范围作为初始边界
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归辅助方法，验证BST属性
     * @param node 当前验证的节点
     * @param lower 当前子树允许的最小值
     * @param upper 当前子树允许的最大值
     * @return 如果以'node'为根的子树是有效的BST则返回true
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        // 基本情况：空树是有效的BST
        if (node == null) {
            return true;
        }
        
        // 检查当前节点值是否违反BST属性
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        
        // 递归验证左右子树：
        // - 左子树的值必须小于当前节点值
        // - 右子树的值必须大于当前节点值
        return isValidBST(node.left, lower, node.val) && 
               isValidBST(node.right, node.val, upper);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,1,4,null,null,3,6]\n
 * // @lcpr case=end
 * 
 */

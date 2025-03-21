/*
 * @lc app=leetcode.cn id=LCR 176 lang=java
 * @lcpr version=30204
 *
 * [LCR 176] 判断是否为平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int righHeight = getHeight(root.right);
        if (Math.abs(leftHeight - righHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算二叉树的高度
     * 关键在于+1这步
     * 
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2,3,3,null,null,4,4]\n
 * // @lcpr case=end
 * 
 */

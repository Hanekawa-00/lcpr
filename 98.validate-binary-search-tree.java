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
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean validate(TreeNode root, long up, long low) {
        if (root == null) {
            return true;
        }
        if (root.val >= up || root.val <= low) {
            return false;
        }
        return validate(root.left,(long) root.val, low) && validate(root.right, up, (long) root.val);
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

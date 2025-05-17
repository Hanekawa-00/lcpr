/*
 * @lc app=leetcode.cn id=LCR 175 lang=java
 * @lcpr version=30204
 *
 * [LCR 175] 计算二叉树的深度
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
    public int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 深度优先遍历
        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1, 2, 2, 3, null, null, 5, 4, null, null, 4]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=124 lang=java
 * @lcpr version=
 *
 * [124] 二叉树中的最大路径和
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
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = dfs(node.left);
        int rightGain = dfs(node.right);
        leftGain = Math.max(0, leftGain);
        rightGain = Math.max(0, rightGain);
        int currentPathWithBend = node.val + leftGain + rightGain;
        maxSum = Math.max(currentPathWithBend, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-10,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 */

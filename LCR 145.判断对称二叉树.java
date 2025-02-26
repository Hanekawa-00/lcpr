/*
 * @lc app=leetcode.cn id=LCR 145 lang=java
 * @lcpr version=30204
 *
 * [LCR 145] 判断对称二叉树
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
    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 对两个子树进行深度遍历，而不是从根节点开始
        return check(root.left, root.right);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val) && check(root1.right, root2.left) && check(root1.left, root2.right);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [6,7,7,8,9,9,8]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2,null,3,null,3]\n
 * // @lcpr case=end
 * 
 */

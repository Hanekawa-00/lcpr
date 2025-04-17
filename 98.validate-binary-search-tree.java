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
        // 左右节点不仅有小于或者大于根节点的约束，还有二者都要在界限之间的约束（再上一层的根节点约束）
        return validate(root, null, null);
    }

    /**
     * @param node
     * @param lower 下界
     * @param upper 上界
     * @return
     */
    private boolean validate(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }
        return validate(node.left, lower, node.val)
                && validate(node.right, node.val, upper);
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

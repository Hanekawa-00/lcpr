/*
 * @lc app=leetcode.cn id=LCR 143 lang=java
 * @lcpr version=30204
 *
 * [LCR 143] 子结构判断
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 判断是否B为当前根节点开始的子树或者B结构在左子树中或者在右子树中
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode root1, TreeNode root2) {
        // root2遍历完说明包含这个结构（子树）
        if (root2 == null) {
            return true;
        }
        // root1先遍历完
        if (root1 == null) {
            return false;
        }
        // 值判断 & 包含B的左右子树
        return (root1.val == root2.val) && isSub(root1.left, root2.left) && isSub(root1.right, root2.right);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,7,5]\n[6,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,6,7,1,8]\n[6,1]\n
 * // @lcpr case=end
 * 
 */

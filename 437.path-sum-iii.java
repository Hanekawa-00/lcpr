/*
 * @lc app=leetcode.cn id=437 lang=java
 * @lcpr version=30204
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,5,-3,3,2,null,11,3,-2,null,1]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
 * // @lcpr case=end
 * 
 */

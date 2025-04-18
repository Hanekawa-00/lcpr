/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30204
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootIndex = (left + right) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, left, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, right);
        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-10,-3,0,5,9]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,3]\n
 * // @lcpr case=end
 * 
 */

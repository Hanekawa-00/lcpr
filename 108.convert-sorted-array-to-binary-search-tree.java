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
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTreeHelper(nums, 0, nums.length - 1);
    }

    private TreeNode buildTreeHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 平衡二叉树要左右子树都要尽量平衡
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // nums天然有序，所以不用考虑构建搜索树的痛点
        root.left = buildTreeHelper(nums, left, mid - 1);
        root.right = buildTreeHelper(nums, mid + 1, right);
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

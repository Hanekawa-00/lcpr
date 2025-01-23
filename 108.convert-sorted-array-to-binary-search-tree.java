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
        return toBST(nums, 0, nums.length - 1);
    }

    /**
     * 平衡二叉树->左右子树高度相等，可以想到要二分
     * 因为是排序数组，则任何一个元素的左区间的任何一个元素都小于这个元素，右区间则全部大于，满足搜索二叉树的左右区间
     * 我们可以根据这两个点构造平衡二叉搜索树
     * 
     * 
     * @param nums
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private TreeNode toBST(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        int rootIndex = (leftIndex + rightIndex) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = toBST(nums, leftIndex, rootIndex - 1);
        root.right = toBST(nums, rootIndex + 1, rightIndex);
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

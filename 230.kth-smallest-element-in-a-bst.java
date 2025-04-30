/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30204
 *
 * [230] 二叉搜索树中第 K 小的元素
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
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        int[] cache = new int[k];
        dfs(root, cache);
        return cache[0];
    }

    private void dfs(TreeNode root, int[] cache) {
        // 中序遍历
        if (root == null) {
            return;
        }
        dfs(root.left, cache);
        //
        if (k == 0) {
            return;
        }
        cache[k-- - 1] = root.val;
        //
        dfs(root.right, cache);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,1,4,null,2]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,3,6,2,4,null,null,1]\n3\n
 * // @lcpr case=end
 * 
 */

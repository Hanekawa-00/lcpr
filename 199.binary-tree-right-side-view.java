/*
 * @lc app=leetcode.cn id=199 lang=java
 * @lcpr version=30204
 *
 * [199] 二叉树的右视图
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();

        }
        List<Integer> res = new ArrayList<>();
        rightSideViewHelper(root, res, 0); // 调用辅助函数，传入初始深度 0
        return res;
    }

    /**
     * @param root      当前节点
     * @param res       结果集
     * @param currDepth 当前遍历的深度
     */
    private void rightSideViewHelper(TreeNode root, List<Integer> res, int currDepth) {
        if (root == null) {
            return; // 递归终止条件
        }
        // 如果当前深度在 res 中还没有元素，说明这是当前深度的最右节点 (因为我们先遍历右子树)
        if (res.size() == currDepth) {// 如果size等于当前深度则说明当前深度并没有添加节点
            res.add(root.val); // 将当前节点值添加到 res 列表中
        }
        // 优先遍历右子树，保证右子树的节点先被访问到
        rightSideViewHelper(root.right, res, currDepth + 1);
        rightSideViewHelper(root.left, res, currDepth + 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,null,5,null,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,null,null,null,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,null,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */

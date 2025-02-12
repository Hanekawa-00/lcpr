/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30204
 *
 * [230] 二叉搜索树中第 K 小的元素
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int kthSmallest(TreeNode root, int k) {
        // 使用stack来保存路径节点
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        // 中序遍历（在二叉搜索树中的排序就是按照中序遍历的顺序来的）
        // 使用stack来辅助遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 这里是遍历点
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
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

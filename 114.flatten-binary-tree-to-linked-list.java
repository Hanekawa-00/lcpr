/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30204
 *
 * [114] 二叉树展开为链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.LinkedList;
import java.util.Stack;

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 1. 递归地展开左子树和右子树
        flatten(root.left);
        flatten(root.right);

        // 2. 保存已展开的左子树和右子树的头部
        TreeNode flattenedLeftSubtree = root.left;
        TreeNode flattenedRightSubtree = root.right;

        // 3. 将当前节点的左指针置为null
        root.left = null;

        // 4. 如果存在已展开的左子树，则进行连接
        if (flattenedLeftSubtree != null) {
            // 将当前节点的右指针指向已展开的左子树
            root.right = flattenedLeftSubtree;

            // 找到已展开左子树的尾部节点
            TreeNode currentTail = flattenedLeftSubtree;
            while (currentTail.right != null) {
                currentTail = currentTail.right;
            }
            // 将左子树的尾部连接到已展开的右子树的头部
            currentTail.right = flattenedRightSubtree;
        } else {
            // 如果没有左子树，则当前节点的右指针直接指向已展开的右子树
            // (如果右子树也为空，则 root.right 会是 null)
            root.right = flattenedRightSubtree;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,5,3,4,null,6]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */

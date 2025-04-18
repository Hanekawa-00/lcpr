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
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            // 前序遍历是根左右，因为stack是先进后出，要先遍历左，则后入栈
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
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

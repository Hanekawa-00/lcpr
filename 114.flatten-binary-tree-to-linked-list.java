/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30204
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 假设一个前置节点
        TreeNode head = new TreeNode(-1);
        preOrder(root, head);
    }

    private TreeNode preOrder(TreeNode root, TreeNode head) {
        if (root == null) {
            return head;
        }
        // 暂存左右子节点，方便递归子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 更新right
        head.right = root;
        // 移动head
        head = head.right;
        // 因为现在head指向的是root节点，存在左节点，这里更新左节点为null，由此可以知道前面为什么要暂存左右子节点
        head.left = null;
        head = preOrder(left, head);
        head = preOrder(right, head);
        return head;
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

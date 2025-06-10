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
    // 用于存储第 k 小的元素的值
    private int result;
    // 用作倒数计数器，当它减到 0 时，当前节点就是第 k 小的元素
    private int kCounter;

    public int kthSmallest(TreeNode root, int k) {
        this.kCounter = k;
        
        // result 会在 inOrderTraversal 方法中被赋值
        inOrderTraversal(root);
        return this.result;
    }

    /**
     * 中序遍历辅助函数
     * 
     * @param node 当前遍历到的节点
     */
    private void inOrderTraversal(TreeNode node) {
        // 基本情况：如果节点为空，或者已经找到了第 k 小的元素，则返回
        if (node == null || kCounter <= 0) {
            return;
        }

        // 1. 遍历左子树
        inOrderTraversal(node.left);

        // 如果在左子树中已经找到了第 k 小的元素 (kCounter <= 0)，则无需继续处理当前节点和右子树
        if (kCounter <= 0) {
            return;
        }

        // 2. 处理当前节点 (根节点)
        // 每访问一个节点，kCounter 减 1
        this.kCounter--;
        // 如果 kCounter 减到 0，说明当前节点就是第 k 小的元素
        if (this.kCounter == 0) {
            this.result = node.val;
            return; // 已经找到，可以结束遍历
        }

        // 3. 遍历右子树 (仅当尚未找到第 k 小的元素时)
        // kCounter > 0 的情况下才会进入右子树的遍历
        // (如果 kCounter 已经是 0 或负数，下一次递归调用开始时的检查会直接返回)
        inOrderTraversal(node.right);
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

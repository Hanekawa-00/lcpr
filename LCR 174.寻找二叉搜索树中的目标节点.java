/*
 * @lc app=leetcode.cn id=LCR 174 lang=java
 * @lcpr version=
 *
 * [LCR 174] 寻找二叉搜索树中的目标节点
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
    int count = 0;
    int result = -1;

    public int findTargetNode(TreeNode root, int cnt) {
        reverseInOrder(root, cnt);
        return result;
    }

    /**
     * 反向中序遍历
     * 
     * @param root
     * @param cnt
     */
    private void reverseInOrder(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }
        reverseInOrder(root.right, cnt);
        // 计数
        count++;
        if (count == cnt) {
            // 从大到小遍历获取到目标值
            this.result = root.val;
            // 剪枝
            return;
        }
        reverseInOrder(root.left, cnt);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [7, 3, 9, 1, 5]\n27/ \3 9/ \1 5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [10, 5, 15, 2, 7, null, 20, 1, null, 6, 8]\n410/ \5 15/ \ \2 7 20/ / \ 1 6
 * 8\n
 * // @lcpr case=end
 * 
 */

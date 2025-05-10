/*
 * @lc app=leetcode.cn id=LCR 143 lang=java
 * @lcpr version=30204
 *
 * [LCR 143] 子结构判断
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 根据题意，空树 B 不是任何树 A 的子结构。
        if (B == null) {
            return false;
        }
        // 如果 A 为空（但 B 不为空），则 B 不可能是 A 的子结构。
        if (A == null) {
            return false;
        }

        // 检查三种可能性：
        // 1. B 的结构与以 A 为根的子树完全相同。
        // 2. B 是 A 左子树的子结构。
        // 3. B 是 A 右子树的子结构。
        // 这三者满足其一即可。
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 辅助函数，判断以节点 a 为根的树是否在结构和节点值上与以节点 b 为根的树完全一样。
     * (即，a 是否 "包含" b 从根节点开始的结构)
     */
    private boolean helper(TreeNode a, TreeNode b) {
        // 如果 b 树的部分已经匹配完毕 (b 为 null)，说明到目前为止是匹配的。
        if (b == null) {
            return true;
        }
        // 如果 b 树还有节点，但 a 树的部分已经没了 (a 为 null)，说明不匹配。
        if (a == null) {
            return false;
        }
        // 如果当前节点值不相等，则不匹配。
        if (a.val != b.val) {
            return false;
        }
        // 当前节点值相等，则递归比较左右子树是否也都匹配。
        return helper(a.left, b.left) && helper(a.right, b.right);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,7,5]\n[6,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,6,7,1,8]\n[6,1]\n
 * // @lcpr case=end
 * 
 */

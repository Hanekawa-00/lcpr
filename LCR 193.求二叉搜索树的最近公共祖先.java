/*
 * @lc app=leetcode.cn id=LCR 193 lang=java
 * @lcpr version=30204
 *
 * [LCR 193] 二叉搜索树的最近公共祖先
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
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                //根据二叉搜索树的特性，如果分在两颗子树上说明肯定是当前根结点
                return curr;
            }
        }
        return curr;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [6,2,8,0,4,7,9,null,null,3,5]\n2\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [6,2,8,0,4,7,9,null,null,3,5]\n2\n4\n
 * // @lcpr case=end
 * 
 */

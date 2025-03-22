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
    /**
     * 要找到公共祖先，那么就要找出两个节点的路径（根结点到目标节点）
     * 这两条路径的交叉节点就是目标节点（最近公共祖先）
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < qPath.size() && i < pPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ancestor = pPath.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> pathList = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            pathList.add(node);
            // 如果target的数值应该更小，那么应该向左子树选找
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        // 最后添加目标节点
        pathList.add(node);
        return pathList;
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

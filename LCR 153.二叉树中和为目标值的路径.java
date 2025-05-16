/*
 * @lc app=leetcode.cn id=LCR 153 lang=java
 * @lcpr version=30204
 *
 * [LCR 153] 二叉树中和为目标值的路径
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
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
    private List<List<Integer>> res;

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrack(root, new ArrayList<>(), target);
        return res;
    }

    private void backtrack(TreeNode currNode, List<Integer> pathList, int target) {
        if (currNode == null) {
            return;
        }
        int currVal = currNode.val;
        pathList.add(currVal);
        // 遍历到叶子节点,并且已经找到target路径
        if (currNode.left == null && currNode.right == null && target - currVal == 0) {
            res.add(new ArrayList<>(pathList));
            // pathList.remove(pathList.size() - 1);
            // return;
        }
        backtrack(currNode.left, pathList, target - currVal);
        backtrack(currNode.right, pathList, target - currVal);
        pathList.remove(pathList.size() - 1);
        return;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n0\n
 * // @lcpr case=end
 * 
 */

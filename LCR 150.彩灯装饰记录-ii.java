/*
 * @lc app=leetcode.cn id=LCR 150 lang=java
 * @lcpr version=30204
 *
 * [LCR 150] 彩灯装饰记录 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> decorateRecord(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode poll = queue.poll();
                item.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(item);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [8,17,21,18,null,null,6]\n
 * // @lcpr case=end
 * 
 */

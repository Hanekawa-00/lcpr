/*
 * @lc app=leetcode.cn id=LCR 149 lang=java
 * @lcpr version=30204
 *
 * [LCR 149] 彩灯装饰记录 I
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
    public int[] decorateRecord(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>() {
            {
                add(root);
            }
        };
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ans = new int[resList.size()];
        int i = 0;
        for (Integer item : resList) {
            ans[i] = item;
            i++;
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [8,17,21,18,null,null,6]\n
 * // @lcpr case=end
 * 
 */

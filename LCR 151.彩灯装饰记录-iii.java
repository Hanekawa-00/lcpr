/*
 * @lc app=leetcode.cn id=LCR 151 lang=java
 * @lcpr version=30204
 *
 * [LCR 151] 彩灯装饰记录 III
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
        // 双端队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            // 正序层
            ArrayList<Integer> item1 = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeFirst();
                item1.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            // 逆序层
            ArrayList<Integer> item2 = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeLast();
                item2.add(node.val);
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            if (!item1.isEmpty()) {
                res.add(item1);
            }
            if (!item2.isEmpty()) {
                res.add(item2);
            }
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

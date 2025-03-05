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
        List<List<Integer>> resList = new ArrayList<>();
        // 使用双端队列，既可以从头出，也可以从尾出
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        int row = 1;
        while (!queue.isEmpty()) {// 每次循环都遍历两层（奇偶）想象成是一个s型遍历
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            // 遍历奇数层
            for (int i = queue.size(); i > 0; i--) {
                // 普通顺序出队
                TreeNode node = queue.removeFirst();
                tempList.add(node.val);
                // 下一层数据入队（从队尾）
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            // 保存
            resList.add(tempList);
            // 如果下一层没有数据则说明到达最后一层直接退出
            if (queue.isEmpty()) {
                break;
            }
            tempList = new ArrayList<>();
            // 遍历偶数层
            for (int i = queue.size(); i > 0; i--) {
                // 由于偶数层要倒序，所以要从队尾出
                TreeNode node = queue.removeLast();
                tempList.add(node.val);
                // 下一层入队（从队头入队）
                // 注意这里从右边开始入队
                if (node.right != null) {
                    queue.addFirst(node.right);
                }
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
            }
            resList.add(tempList);
        }
        return resList;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [8,17,21,18,null,null,6]\n
 * // @lcpr case=end
 * 
 */

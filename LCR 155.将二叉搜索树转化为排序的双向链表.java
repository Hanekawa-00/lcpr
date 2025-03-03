/*
 * @lc app=leetcode.cn id=LCR 155 lang=java
 * @lcpr version=30204
 *
 * [LCR 155] 将二叉搜索树转化为排序的双向链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    // 在中序遍历时记住最左节点以及前一个节点
    // 用来维护链表头
    Node head = null;
    // 上一个节点
    Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 中序遍历
        dfs(root);
        // head当前为第一个节点
        head.left = prev;
        // 此时prev已经到最后一个节点了
        prev.right = head;
        return head;
    }

    private void dfs(Node curr) {
        if (curr == null) {
            return;
        }
        // 遍历左子树
        dfs(curr.left);
        // 处理当前子树根结点
        if (prev == null) {
            // 如果prev为空说明这是第一个元素
            head = curr;
        } else {
            // 非第一个元素，将上一个元素的right（也就是next）指向当前元素
            prev.right = curr;
            // 当前元素的left（也就是pre）指向前一个元素
            curr.left = prev;
        }
        // 准备递归右子树，更新prev为当前节点
        prev = curr;
        dfs(curr.right);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,2,5,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */

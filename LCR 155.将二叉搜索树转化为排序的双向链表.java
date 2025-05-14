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
    // 只保存头节点
    private Node head;
    // 这个节点用来中序遍历
    private Node node;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        head.left = node;
        node.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        //
        if (node == null) {
            head = root;
            node = root;
        } else {
            node.right = root;
            root.left = node;
            node = node.right;// 更新
        }
        //
        dfs(root.right);
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

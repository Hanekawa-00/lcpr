/*
 * @lc app=leetcode.cn id=LCR 154 lang=java
 * @lcpr version=30204
 *
 * [LCR 154] 复杂链表的复制
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 先遍历链表，复制前后顺序，并添加映射关系，方便使用random连接
        Node pre = null; // 辅助节点
        while (node != null) {
            Node newNode = new Node(node.val);
            if (pre != null) {
                pre.next = newNode;
            }
            map.put(node, newNode);
            pre = newNode;
            node = node.next;
        }
        node = head;
        // 创建random连接关系
        while (node != null) {
            Node curr = map.get(node);
            if (node.random == null) {
                curr.random = null;
            } else {
                curr.random = map.get(node.random);
            }
            node = node.next;
        }
        return map.get(head);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[7,null],[13,0],[11,4],[10,2],[1,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,1],[2,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[3,null],[3,0],[3,null]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */

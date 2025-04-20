/*
 * @lc app=leetcode.cn id=138 lang=java
 * @lcpr version=30204
 *
 * [138] 随机链表的复制
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
import java.util.Map;


class Solution {
    public Node copyRandomList(Node head) {
        // key为原链表的节点，val为新链表的节点
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        // 先构建哈希映射
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        // 构建新节点之间的关系
        node = head;
        while (node != null) {
            Node random = node.random;
            Node next = node.next;
            Node newNode = map.get(node);
            newNode.next = map.get(next);
            newNode.random = map.get(random);
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
 */

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

        // 使用 Map<Node, Node> 来记录旧节点 -> 新节点的映射关系
        Map<Node, Node> map = new HashMap<>();

        // 第一遍遍历：先把所有节点复制一遍，只处理节点本身和 next 指针
        Node oldNode = head;
        while (oldNode != null) {
            // 创建一个新的节点(如果还没建过)
            if (!map.containsKey(oldNode)) {
                map.put(oldNode, new Node(oldNode.val));
            }

            // 处理 next
            if (oldNode.next != null) {
                if (!map.containsKey(oldNode.next)) {
                    map.put(oldNode.next, new Node(oldNode.next.val));
                }
                // 令新节点的 next 指向 老节点的 next 对应的新节点
                map.get(oldNode).next = map.get(oldNode.next);
            }

            oldNode = oldNode.next;
        }

        // 第二遍遍历：处理 random 指针
        oldNode = head;
        while (oldNode != null) {
            if (oldNode.random != null) {
                // 新节点的 random = 老节点 random 对应的新节点
                map.get(oldNode).random = map.get(oldNode.random);
            } else {
                // 如果原节点的 random 为 null，则新节点 random 也为 null
                map.get(oldNode).random = null;
            }
            oldNode = oldNode.next;
        }

        // 返回头结点对应的新节点
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

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
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node pre = new Node(-1);
        Node resPre = pre;
        while (curr != null) {
            int val = curr.val;
            Node node = new Node(val);
            map.put(curr, node);
            pre.next = node;
            pre = pre.next;
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random == null) {
                map.get(curr).random = null;
            } else {
                map.get(curr).random = map.get(random);
            }
            curr = curr.next;
        }
        return resPre.next;
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

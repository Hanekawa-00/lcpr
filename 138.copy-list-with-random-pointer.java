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
        // 哈希表用来存储旧链表和新链表的对应关系
        Map<Node, Node> catchedMap = new HashMap<>();
        return deepCopy(head, catchedMap);
    }

    /**
     * @param targetNode 需要复制的目标节点
     * @param cachedMap
     * @return
     */
    private Node deepCopy(Node targetNode, Map<Node, Node> cachedMap) {
        if (targetNode == null) {
            // 递归到最后则为null
            return null;
        }
        // 这里是为了防止random导致节点重复
        if (!cachedMap.containsKey(targetNode)) {
            Node newHead = new Node(targetNode.val);
            cachedMap.put(targetNode, newHead);
            // 递归获取新的next和random
            newHead.next = deepCopy(targetNode.next, cachedMap);
            newHead.random = deepCopy(targetNode.random, cachedMap);
        }
        // 如果map中含有目标节点（已经保存到map中，但可能没有处理完成next或者random,所以必须要返回map中的指针）则直接返回
        return cachedMap.get(targetNode);
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

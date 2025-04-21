/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30204
 *
 * [146] LRU 缓存
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // 内部节点类，用于双向链表
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {} // 构造哨兵节点

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // 哨兵头节点,维护最近使用过的节点
    private final Node tail; // 哨兵尾节点，维护最久未使用节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // 初始化哨兵节点并连接
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    // 将节点移动到链表头部（tail 的前面）
    private void moveToHead(Node node) {
        removeNode(node); // 先从当前位置移除
        addToHead(node);  // 再添加到头部
    }

    // 从双向链表中移除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点添加到链表头部（tail 的前面）
    private void addToHead(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    // 移除链表尾部节点（head 的后面），即最久未使用的节点
    private Node removeTail() {
        Node res = head.next;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        Node node = map.get(key);
        // key 不存在
        if (node == null) {
            return -1;
        }
        // key 存在，将其移动到链表头部表示最近使用
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            // key 已存在，更新 value 并移动到头部
            node.value = value;
            moveToHead(node);
        } else {
            // key 不存在，创建新节点
            Node newNode = new Node(key, value);
            map.put(key, newNode); // 加入 map
            addToHead(newNode);    // 加入链表头部

            // 检查是否超出容量
            if (map.size() > capacity) {
                // 超出容量，移除链表尾部节点（最久未使用）
                Node tailNode = removeTail();
                map.remove(tailNode.key); // 从 map 中移除
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

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
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> cacheMap;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        cacheMap = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    private void moveToTail(LRUCache.Node node) {
        deleteNode(node);
        addToTail(node);
    }

    private void addToTail(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            addToTail(node);
            cacheMap.put(key, node);
            size++;
        } else {
            node.value = value;
            moveToTail(node);
        }
        if (size > capacity) {
            cacheMap.remove(head.next.key);
            deleteNode(head.next);
            size--;
        }
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node != null) {
            moveToTail(node);
            return node.value;
        }
        return -1;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

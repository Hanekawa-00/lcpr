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

class LRUCache {
    private int capacity;
    private HashMap<Integer, Integer> cacheMap;
    private int count;
    private int headKey;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.headKey = -1;
        cacheMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        int val = -1;
        if (cacheMap.containsKey(key)) {
            val = cacheMap.get(key);
            cacheMap.remove(key);
        }
        return val;
    }

    public void put(int key, int value) {
        if (count == 0) {
            headKey = key;
        }
        if (count + 1 > capacity) {
            cacheMap.remove(headKey);
        }
        if (!cacheMap.containsKey(key)) {
            count++;
        }
        cacheMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

/*
 * @lc app=leetcode.cn id=LCR 184 lang=java
 * @lcpr version=
 *
 * [LCR 184] 设计自助结算系统
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Checkout {
    Queue<Integer> queue;
    /**
     * 双端队列维护有序最大值
     */
    Deque<Integer> deque;

    public Checkout() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int get_max() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void add(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            // 由于队列先进先出的特性，这里出队并不会影响
            // 队列是往后看来获取最大值
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int remove() {
        if (queue.isEmpty()) {
            return -1;
        }
        int ans = queue.poll();
        if (ans == deque.peekFirst()) {
            deque.pollFirst();
        }
        return ans;
    }
}

/**
 * Your Checkout object will be instantiated and called as such:
 * Checkout obj = new Checkout();
 * int param_1 = obj.get_max();
 * obj.add(value);
 * int param_3 = obj.remove();
 */
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * ["Checkout","add","add","get_max","remove","get_max"][[],[4],[7],[],[],[]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["Checkout","remove","get_max"][[],[],[]]\n
 * // @lcpr case=end
 * 
 */

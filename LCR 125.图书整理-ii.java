/*
 * @lc app=leetcode.cn id=LCR 125 lang=java
 * @lcpr version=30204
 *
 * [LCR 125] 图书整理 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class CQueue {
    private Queue<Integer> queue;

    public CQueue() {
        queue = new LinkedList<>();
    }

    public void push(int bookId) {
        appendTail(bookId);
    }

    public Integer pop() {
        return deleteHead();
    }

    public void appendTail(int value) {
        queue.offer(value);
    }

    public Integer deleteHead() {
        Integer res = queue.poll();
        return res == null ? -1 : res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
// @lc code=end

/*
 * // @lcpr case=start
 * // ["BookQueue", "push", "push", "pop"][[], [1], [2], []]\n
 * // @lcpr case=end
 * 
 */

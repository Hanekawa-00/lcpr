/*
 * @lc app=leetcode.cn id=LCR 125 lang=java
 * @lcpr version=30204
 *
 * [LCR 125] 图书整理 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class CQueue {
    // 用来保存读者归还的书
    private Deque<Integer> inStack;
    // 用来保存图书管理员取出的书
    private Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2Out();
        }
        return outStack.pop();
    }

    /**
     * 将输入栈中的数据转移到out栈中
     * 因为读者归还的顺序是从下到上，管理员取书的顺序是从上往下，和出栈的顺序正好相反
     */
    private void in2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
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

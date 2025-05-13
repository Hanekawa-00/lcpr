/*
 * @lc app=leetcode.cn id=LCR 147 lang=java
 * @lcpr version=30204
 *
 * [LCR 147] 最小栈
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Integer> dataStack;
    // 这个用来同步dataStack每个状态中的最小值
    private Deque<Integer> minTrackerStack;

    public MinStack() {
        dataStack = new ArrayDeque<>();
        minTrackerStack = new ArrayDeque<>();
    }

    public void push(int val) {
        dataStack.push(val);
        if (minTrackerStack.isEmpty() || val <= minTrackerStack.peek()) {
            minTrackerStack.push(val);
        } else {
            minTrackerStack.push(minTrackerStack.peek());// 因为之前的最小值仍然是当前栈状态下的最小值
        }
    }

    public void pop() {
        dataStack.pop();
        minTrackerStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minTrackerStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * ["MinStack","push","push","push","getMin","pop","top","getMin"][[],[-2],[0],[
 * -3],[],[],[],[]]\n
 * // @lcpr case=end
 * 
 */

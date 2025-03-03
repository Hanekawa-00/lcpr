/*
 * @lc app=leetcode.cn id=LCR 147 lang=java
 * @lcpr version=30204
 *
 * [LCR 147] 最小栈
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class MinStack {
    int min;
    int[] stack;
    int size;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[10];
        min = Integer.MAX_VALUE;
        size = 0;
    }

    private void checkAndResize() {
        if (size < stack.length) {
            return;
        } else {
            int[] newStack = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }

    public void push(int x) {
        checkAndResize();
        stack[size] = x;
        size++;
        min = Math.min(min, x);
    }

    public void pop() {
        size--;
        if (stack[size] == min) {
            refreshMin();
        }
    }

    private void refreshMin() {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, stack[i]);
        }
    }

    public int top() {
        return stack[size - 1];
    }

    public int getMin() {
        return min;
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

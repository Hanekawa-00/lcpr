/*
 * @lc app=leetcode.cn id=155 lang=java
 * @lcpr version=30204
 *
 * [155] 最小栈
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class MinStack {
    private class Node {
        int val;
        Node next;
        Node prev; // 协助出栈
        int currentMin; // 在入栈时的整个链表的最小值,在出栈时候，最小值自动切换为新top入栈时最小值

        public Node(int val, int currentMin) {
            this.val = val;
            this.currentMin = currentMin;
        }
    }

    public Node top;

    public MinStack() {
        top = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public void push(int val) {
        int min = val < top.currentMin ? val : top.currentMin;
        Node newNode = new Node(val, min);
        newNode.prev = top;
        top.next = newNode;
        top = newNode;
    }

    public void pop() {
        Node oldTop = this.top;
        Node newTop = oldTop.prev;
        newTop.next = null;
        oldTop.prev = null;
        this.top = newTop;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return this.top.currentMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
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

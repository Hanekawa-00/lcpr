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
    class Node {
        int val;
        Node next;
        Node prev;
        int currMin;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node top;

    public MinStack() {
    }

    public int getMin() {
        return top.currMin;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        if (top == null) {
            newNode.currMin = val;
            top = newNode;
        } else {
            newNode.currMin = getMin() < val ? getMin() : val;
            top.next = newNode;
            newNode.prev = top;
            top = newNode;
        }
    }

    public void pop() {
        Node prev = top.prev;
        top.prev = null;
        if (prev != null) {
            prev.next = null;
        }
        top = prev;
    }

    public int top() {
        return top.val;
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

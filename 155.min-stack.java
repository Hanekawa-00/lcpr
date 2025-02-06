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
    class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode min;
    ListNode top;

    public MinStack() {
        min = null;
        top = null;
    }

    public void push(int val) {
        if (top == null) {
            top = new ListNode(val);
        } else {
            ListNode pre = top;
            top.next = new ListNode(val);
            top = top.next;
            top.pre = pre;
        }
        checkMin();
    }

    private void checkMin() {
        min = top;
        ListNode curr = top;
        while (curr != null) {
            min = curr.val <= min.val ? curr : min;
            curr = curr.pre;
        }
    }

    public void pop() {
        top = top.pre;
        checkMin();
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return min.val;
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

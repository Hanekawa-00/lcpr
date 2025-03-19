/*
 * @lc app=leetcode.cn id=LCR 184 lang=java
 * @lcpr version=
 *
 * [LCR 184] 设计自助结算系统
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Checkout {
    int max;
    Node head;
    Node tail;

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Checkout() {
        this.max = Integer.MIN_VALUE;
        head = null;
        tail = null;
    }

    public int get_max() {
        if (this.max > Integer.MIN_VALUE) {
            return this.max;
        }
        return -1;
    }

    public void add(int value) {
        Node node = new Node(value);
        this.max = Math.max(max, value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public int remove() {
        if (head == null) {
            return -1;
        }
        int targetVal = head.val;
        head = head.next;
        
        // 如果队列为空，重置最大值
        if (head == null) {
            tail = null;
            max = Integer.MIN_VALUE;
        } 
        // 如果移除的是最大值，重新计算最大值
        else if (targetVal == max) {
            max = Integer.MIN_VALUE;
            Node current = head;
            while (current != null) {
                max = Math.max(max, current.val);
                current = current.next;
            }
        }
        
        return targetVal;
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

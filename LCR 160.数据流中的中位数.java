import java.util.PriorityQueue;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=LCR 160 lang=java
 * @lcpr version=
 *
 * [LCR 160] 数据流中的中位数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class MedianFinder {
    private PriorityQueue<Integer> smallHalf; // 最大堆，存储较小的一半数字
    private PriorityQueue<Integer> largeHalf; // 最小堆，存储较大的一半数字

    public MedianFinder() {
        smallHalf = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        largeHalf = new PriorityQueue<>(); // Min-heap
    }

    public void addNum(int num) {
        // 1. 将新数字加入 smallHalf (最大堆)
        smallHalf.offer(num);

        // 2. 为了维持 smallHalf 所有元素 <= largeHalf 所有元素的特性，
        // 将 smallHalf 中最大的元素（堆顶）移到 largeHalf。
        largeHalf.offer(smallHalf.poll());

        // 3. 平衡两个堆的大小，确保 smallHalf 的大小等于或比 largeHalf 大1。
        // 如果 largeHalf 的元素个数超过 smallHalf，则将 largeHalf 最小的元素（堆顶）移回 smallHalf。
        if (largeHalf.size() > smallHalf.size()) {
            smallHalf.offer(largeHalf.poll());
        }
    }

    public double findMedian() {
        // 如果 smallHalf 的元素比 largeHalf 多，说明总元素个数为奇数，
        // 中位数是 smallHalf 的堆顶。
        if (smallHalf.size() > largeHalf.size()) {
            return (double) smallHalf.peek();
        } else {
            // 如果两个堆大小相等（或者 smallHalf 为空，虽然在 addNum 后 smallHalf 不会比 largeHalf 小），
            // 说明总元素个数为偶数，中位数是两个堆顶元素的平均值。
            // 题目提示调用次数，暗示 findMedian 不会在完全空的情况下被要求给出有效中位数，
            // 或者说 addNum 至少被调用一次。
            if (smallHalf.isEmpty()) { // 防御性检查，理论上如果 addNum 被调用过，smallHalf 不会空
                return 0.0; // 或者抛出异常，表示没有元素可计算中位数
            }
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"][[],[1],
 * [2],[],[3],[]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"][[],[2],[],[3],[]
 * ]\n
 * // @lcpr case=end
 * 
 */

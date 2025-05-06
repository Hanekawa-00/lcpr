/*
 * @lc app=leetcode.cn id=LCR 120 lang=java
 * @lcpr version=30204
 *
 * [LCR 120] 寻找文件副本
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int findRepeatDocument(int[] documents) {
        int fast = documents[0], slow = documents[0];
        do {
            slow = documents[slow];
            fast = documents[documents[fast]];
        } while (fast != slow);
        fast = documents[0];
        while (fast != slow) {
            slow = documents[slow];
            fast = documents[fast];
        }
        return fast;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2, 5, 3, 0, 5, 0]\n
 * // @lcpr case=end
 * 
 */

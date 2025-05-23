/*
 * @lc app=leetcode.cn id=LCR 173 lang=java
 * @lcpr version=30204
 *
 * [LCR 173] 点名
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int takeAttendance(int[] records) {
        int left = 0, right = records.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (records[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,2,3,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0, 1, 2, 3, 4, 5, 6, 8]\n
 * // @lcpr case=end
 * 
 */

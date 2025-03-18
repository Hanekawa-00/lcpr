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
            //  如果位置上数据正确，那么缺少的那个肯定在后面的区间
            if (records[mid] == mid) {
                left = mid + 1;
            } else {// 如果不正确，那么缺少的那个数据一定在前面的区间
                right = mid - 1;
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

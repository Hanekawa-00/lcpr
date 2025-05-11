/*
 * @lc app=leetcode.cn id=1550 lang=java
 * @lcpr version=
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            while (i < arr.length && arr[i] % 2 == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,6,4,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,34,3,4,5,7,23,12]\n
 * // @lcpr case=end
 * 
 */

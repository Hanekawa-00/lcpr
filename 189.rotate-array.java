/*
 * @lc app=leetcode.cn id=189 lang=java
 * @lcpr version=30204
 *
 * [189] 轮转数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tempArr = new int[n];
        // 控制k的范围，因为k有可能大于数组长度
        k = k % n;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = nums[(n - k + i) % n]; // 因为是右移，所以要使用n-k作为偏差值
        }
        for (int i = 0; i < n; i++) {
            nums[i] = tempArr[i];
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,-100,3,99]\n2\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=30204
 *
 * [169] 多数元素
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> cacheMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (cacheMap.containsKey(nums[i])) {
                cacheMap.put(nums[i], cacheMap.get(nums[i]) + 1);
                if (i >= n / 2 && cacheMap.get(nums[i]) > n / 2) {
                    return nums[i];
                }
            } else {
                cacheMap.put(nums[i], 1);
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,1,1,1,2,2]\n
 * // @lcpr case=end
 * 
 */

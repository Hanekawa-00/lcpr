/*
 * @lc app=leetcode.cn id=1 lang=java
 * @lcpr version=30204
 *
 * [1] 两数之和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget)) {
                return new int[] { map.get(newTarget), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,7,11,15]\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,4]\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,3]\n6\n
 * // @lcpr case=end
 * 
 */

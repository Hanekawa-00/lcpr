/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30204
 *
 * [560] 和为 K 的子数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            currSum += num;
            int targetPrefixSum = currSum - k;
            if (map.containsKey(targetPrefixSum)) {
                count += map.get(targetPrefixSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,1]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n3\n
 * // @lcpr case=end
 * 
 */

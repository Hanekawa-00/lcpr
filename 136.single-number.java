/*
 * @lc app=leetcode.cn id=136 lang=java
 * @lcpr version=30204
 *
 * [136] 只出现一次的数字
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
        }
        Set<Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        for (Entry<Integer, Integer> itemEntry : entrySet) {
            if (itemEntry.getValue().equals(1)) {
                return itemEntry.getKey();
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,1,2,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */

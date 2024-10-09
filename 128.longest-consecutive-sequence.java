/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30204
 *
 * [128] 最长连续序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; i++) {
        // if (set.contains(nums[i] + 1)) {
        // ArrayList<Object> list = new ArrayList<>();
        // list.add(nums[i]);
        // for (int j = 1; j < nums.length; j++) {

        // }
        // }
        // }
        int count = 0;
        int res = 0;
        for (Integer n : set) {
            if (!set.contains(n - 1)) {
                count = 1;
                while (set.contains(n + 1)) {
                    count++;
                    n += 1;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [100,4,200,1,3,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,3,7,2,5,8,4,6,0,1]\n
 * // @lcpr case=end
 * 
 */

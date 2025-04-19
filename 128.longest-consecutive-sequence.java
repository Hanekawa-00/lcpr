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
import java.util.Set;

class Solution {
    /**
     * 并查集
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // 使用集合，自动去重，还不需要排序就能判断是否有连续序列
        Set<Integer> set = new HashSet<>();
        int longstStreak = 0;
        for (int num : nums) {
            set.add(num);
        }
        // 这里不遍历set会超时
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longstStreak = Math.max(longstStreak, currentStreak);
            }
        }
        return longstStreak;
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

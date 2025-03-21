/*
 * @lc app=leetcode.cn id=LCR 186 lang=java
 * @lcpr version=30204
 *
 * [LCR 186] 文物朝代判断
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkDynasty(int[] places) {
        // 边界条件检查
        if (places == null || places.length != 5) {
            return false;
        }
        // 排序
        Arrays.sort(places);
        Set<Integer> set = new HashSet<Integer>();
        // 遍历数组，统计未知朝代和去重（直接返回）
        for (int i = 0; i < places.length; i++) {
            if (places[i] == 0) {
                continue;
            } else {
                if (set.contains(places[i])) {
                    return false;
                }
                set.add(places[i]);
            }
        }
        // 如果已知朝代为0，或者只有一个已知朝代则直接返回
        if (set.size() == 0 || set.size() == 1) {
            return true;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer num : set) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int maxRange = max - min;
        // 最大差值<5，且无重复，那么就肯定可以连续
        return maxRange < 5;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0, 6, 9, 0, 7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7, 8, 9, 10, 11]\n
 * // @lcpr case=end
 * 
 */

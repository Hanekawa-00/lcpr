/*
 * @lc app=leetcode.cn id=347 lang=java
 * @lcpr version=30204
 *
 * [347] 前 K 个高频元素
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 取出entrySet列表进行排序
        ArrayList<Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        // 取前k个元素的key
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,1,2,2,3]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 */

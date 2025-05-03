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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * 使用桶排序的思想找出前 K 个高频元素。
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     *
     * @param nums 整数数组
     * @param k    需要返回的高频元素的数量
     * @return 包含前 K 个高频元素的数组
     */
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // 1. 统计频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 创建桶数组，索引代表频率
        // 桶的大小需要是 n + 1，因为最大频率可能是 n
        List<Integer>[] buckets = new List[n + 1];

        // 3. 装桶：将数字根据其频率放入对应的桶中
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // 4. 收集结果：从高频率桶开始收集 k 个元素
        int[] result = new int[k];
        int count = 0; // 记录已收集的元素数量

        // 从频率最高的桶 (索引 n) 向下遍历到频率为 1 的桶
        for (int i = n; i >= 1 && count < k; i--) {
            // 如果当前频率的桶不为空
            if (buckets[i] != null) {
                // 将该桶中的所有元素加入结果数组
                for (int num : buckets[i]) {
                    result[count++] = num;
                    // 如果已经收集够 k 个元素，提前结束
                    if (count == k) {
                        break;
                    }
                }
            }
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

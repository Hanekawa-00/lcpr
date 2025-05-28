/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30204
 *
 * [56] 合并区间
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 处理边界情况：如果输入为空，直接返回空数组
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 步骤1：按照区间的起始位置进行排序
        // 使用lambda表达式比较每个区间的第一个元素（起始位置）
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 步骤2：创建结果列表，用于存储合并后的区间
        List<int[]> result = new ArrayList<>();

        // 步骤3：将第一个区间加入结果列表作为初始的合并区间
        result.add(intervals[0]);

        // 步骤4：遍历剩余的区间，逐一判断是否需要合并
        for (int i = 1; i < intervals.length; i++) {
            // 获取当前正在处理的区间
            int[] currentInterval = intervals[i];
            // 获取结果列表中最后一个区间（正在构建的合并区间）
            int[] lastInterval = result.get(result.size() - 1);

            // 判断当前区间是否与最后一个区间重叠
            // 重叠条件：当前区间的起始位置 <= 最后一个区间的结束位置
            if (currentInterval[0] <= lastInterval[1]) {
                // 重叠：合并两个区间
                // 合并后的区间：起始位置保持不变（因为已排序，lastInterval[0] <= currentInterval[0]）
                // 结束位置取两个区间结束位置的最大值
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // 不重叠：将当前区间作为新的独立区间加入结果列表
                result.add(currentInterval);
            }
        }

        // 步骤5：将结果列表转换为二维数组并返回
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3],[2,6],[8,10],[15,18]]\n
 * // @lcpr case=end
 *
 * // @lcpr case=start
 * // [[1,4],[4,5]]\n
 * // @lcpr case=end
 *
 */

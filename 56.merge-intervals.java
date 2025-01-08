import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30204
 *
 * [56] 合并区间
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 如果区间数量小于等于1，直接返回
        if (intervals.length <= 1) {
            return intervals;
        }
        // 按区间起始点升序排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 使用List存储结果，方便动态添加
        List<int[]> result = new ArrayList<>();
        // 初始化当前区间为第一个区间
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        // 遍历所有区间
        for (int[] interval : intervals) {
            // 当前区间的end
            int currentEnd = currentInterval[1];
            // 下一个区间的start
            int nextStart = interval[0];
            // 下一个区间的end
            int nextEnd = interval[1];
            // 如果当前区间与下一个区间有重叠
            if (currentEnd >= nextStart) {
                // 合并区间，取最大的结束点（当前区间的end有可能比下一个区间的end要大）
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // 没有重叠，将当前区间加入结果，并更新当前区间（假如选择的是数组，可以使用index来维护当前位置的元素）
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        // 将List转换为二维数组返回
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

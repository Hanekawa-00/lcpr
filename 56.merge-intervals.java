import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        // 边界条件：如果数组为空或 null，返回空数组
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Step 1: 按起始点 start 升序排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: 初始化结果列表
        List<int[]> result = new ArrayList<>();

        // Step 3: 将第一个区间作为当前区间
        int[] currentInterval = intervals[0];

        // Step 4: 遍历剩余区间，合并重叠区间
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的 start 小于或等于 currentInterval 的 end，说明重叠
            if (intervals[i][0] <= currentInterval[1]) {
                // 更新 currentInterval 的 end 为两者的最大值
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // 不重叠，将 currentInterval 加入结果，并更新 currentInterval 为当前区间
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Step 5: 别忘了将最后一个 currentInterval 加入结果
        result.add(currentInterval);

        // Step 6: 将 List<int[]> 转换为 int[][]
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

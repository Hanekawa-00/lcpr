/*
 * @lc app=leetcode.cn id=LCR 180 lang=java
 * @lcpr version=30204
 *
 * [LCR 180] 文件组合
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] fileCombination(int target) {
        List<int[]> result = new ArrayList<>();
        int left = 1, right = 2;
        
        // 因为我们至少需要两个数字，且序列从1开始，所以 left 最大不会超过 target/2
        while (left <= target / 2) {
            // 使用等差数列公式计算从 left 到 right 的连续整数和
            int sum = (left + right) * (right - left + 1) / 2;
            
            if (sum == target) {
                // 找到一个符合条件的序列
                int[] sequence = new int[right - left + 1];
                for (int i = 0; i < sequence.length; i++) {
                    sequence[i] = left + i;
                }
                result.add(sequence);
                
                // 继续查找下一个可能的序列
                right++;
            } else if (sum < target) {
                // 如果和小于目标，增大窗口
                right++;
            } else {
                // 如果和大于目标，收缩窗口
                left++;
            }
        }
        
        // 转换为二维数组返回
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 18\n
 * // @lcpr case=end
 * 
 */

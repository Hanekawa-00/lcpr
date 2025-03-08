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
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2;
        for (int i = 1; i <= limit; i++) {
            for (int j = i;; j++) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
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

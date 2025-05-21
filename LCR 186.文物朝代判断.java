/*
 * @lc app=leetcode.cn id=LCR 186 lang=java
 * @lcpr version=30204
 *
 * [LCR 186] 文物朝代判断
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean checkDynasty(int[] places) {
        // 用来提取非元素
        List<Integer> nonZeros = new ArrayList<>();
        for (int place : places) {
            if (place != 0) {
                nonZeros.add(place);
            }
        }
        if (nonZeros.isEmpty()) {
            return true;
        }
        // 排序以便判断是否有重复元素和取得最大最小值
        Collections.sort(nonZeros);
        for (int i = 1; i < nonZeros.size(); i++) {
            if (nonZeros.get(i) == nonZeros.get(i - 1)) {
                return false;
            }
        }
        int min = nonZeros.get(0);
        int max = nonZeros.get(nonZeros.size() - 1);
        // 最大最小值相差大于则肯定无法连续
        return max - min < 5;
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

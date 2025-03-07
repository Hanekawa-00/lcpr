/*
 * @lc app=leetcode.cn id=LCR 177 lang=java
 * @lcpr version=30204
 *
 * [LCR 177] 撞色搭配
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int[] sockCollocation(int[] sockets) {
        int[] ans = new int[2];
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < sockets.length; i++) {
            hashMap.put(sockets[i], hashMap.containsKey(sockets[i]));
        }
        int size = 0;
        for (Entry<Integer, Boolean> entry : hashMap.entrySet()) {
            if (!entry.getValue()) {
                ans[size] = entry.getKey();
                size++;
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4, 5, 2, 4, 6, 6]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1, 2, 4, 1, 4, 3, 12, 3]\n
 * // @lcpr case=end
 * 
 */

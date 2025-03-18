/*
 * @lc app=leetcode.cn id=LCR 167 lang=java
 * @lcpr version=30204
 *
 * [LCR 167] 招式拆解 I
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;

class Solution {
    /**
     * 最长不重复子串
     * 
     * @param arr
     * @return
     */
    public int dismantlingAction(String arr) {
        if (arr.length() == 1) {
            return 1;
        }
        char[] charArray = arr.toCharArray();
        int leftIndex = 0;
        int rightIndex = 0;
        int res = 0;
        ArrayList<Character> cacheList;
        for (int i = 0; i < charArray.length; i++) {
            cacheList = new ArrayList<>();
            leftIndex = i;
            rightIndex = i;
            cacheList.add(charArray[leftIndex]);
            for (int j = i + 1; j < charArray.length; j++) {
                if (!cacheList.contains(charArray[j])) {
                    cacheList.add(charArray[j]);
                    rightIndex = j;
                } else {
                    break;
                }
            }
            res = Math.max(res, rightIndex - leftIndex + 1);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "dbascDdad"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "KKK"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "pwwkew"\n
 * // @lcpr case=end
 * 
 */

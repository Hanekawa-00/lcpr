/*
 * @lc app=leetcode.cn id=LCR 167 lang=java
 * @lcpr version=30204
 *
 * [LCR 167] 招式拆解 I
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;

class Solution {
    public int dismantlingAction(String arr) {
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < arr.length()) {
            while (r < arr.length() && !set.contains(arr.charAt(r))) {
                set.add(arr.charAt(r));
                r++;
            }
            res = Math.max(res, set.size());
            while (r < arr.length() && set.contains(arr.charAt(r)) && l <= r) {
                set.remove(arr.charAt(l));
                l++;
            }
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

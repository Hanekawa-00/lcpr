/*
 * @lc app=leetcode.cn id=LCR 182 lang=java
 * @lcpr version=30204
 *
 * [LCR 182] 动态口令
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public String dynamicPassword(String password, int target) {
        // char[] charArray = password.toCharArray();
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < charArray.length; i++) {
        // sb.append(charArray[(i + target) % charArray.length]);
        // }
        // 前闭后开
        sb.append(password.substring(target, password.length())).append(password.substring(0, target));
        return sb.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "s3cur1tyC0d3"\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "lrloseumgh"\n6\n
 * // @lcpr case=end
 * 
 */

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
       StringBuilder sb = new StringBuilder();
       String sub1 = password.substring(0,target);
       String sub2 = password.substring(target, password.length());
       sb.append(sub2);
       sb.append(sub1);
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

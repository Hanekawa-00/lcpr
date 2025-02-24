/*
 * @lc app=leetcode.cn id=LCR 122 lang=java
 * @lcpr version=30204
 *
 * [LCR 122] 路径加密
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String pathEncryption(String path) {
        StringBuilder res = new StringBuilder();
        for(Character c : path.toCharArray())
        {
            if(c == '.') res.append(' ');
            else res.append(c);
        }
        return res.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "a.aef.qerf.bb"\n
// @lcpr case=end

 */


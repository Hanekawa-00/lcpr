/*
 * @lc app=leetcode.cn id=131 lang=java
 * @lcpr version=30204
 *
 * [131] 分割回文串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        dfs(s, 0, n, res, new ArrayList<String>());
        return res;
    }
    /**
     * 判断[left,right]区间内的子串是否为回文字符串
     * 
     * @param left
     * @param right
     * @param s
     * @return
     */
    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(String s, int startIndex, int length, List<List<String>> res, List<String> itemList) {
        if (length == startIndex) {
            // 退出条件是startIndex超过end,也就是正好达到length
            res.add(new ArrayList<>(itemList));
            return;
        }
        for (int j = startIndex; j < length; j++) {
            if (isPalindrome(startIndex, j, s)) {
                itemList.add(s.substring(startIndex, j + 1));// 前闭后开
                dfs(s, j + 1, length, res, itemList);
                // 回退进入下一个子串范围
                itemList.remove(itemList.size() - 1);
            }
        }
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // "aab"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n
 * // @lcpr case=end
 * 
 */

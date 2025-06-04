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
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(String s, List<String> path, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 类似双指针
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                backtrack(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
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

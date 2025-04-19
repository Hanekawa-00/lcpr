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
        this.res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int index, List<String> list) {
        if (index > s.length() - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // 所分割的回文串必须从index开始，路径是从index不断向后面尝试不同的子串
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backtrack(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                return false;
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

/*
 * @lc app=leetcode.cn id=LCR 169 lang=java
 * @lcpr version=30204
 *
 * [LCR 169] 招式拆解 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public char dismantlingAction(String arr) {
        if (arr == null || arr.length() == 0) {
            return ' ';
        }
        int[] count = new int[26]; // 用于统计字符出现次数
        // 第一次遍历：统计每个字符的出现次数
        for (char c : arr.toCharArray()) {
            count[c - 'a']++;
        }
        // 第二次遍历：查找第一个只出现一次的字符
        for (char c : arr.toCharArray()) {
            if (count[c - 'a'] == 1) { // 因为是按顺序遍历的，所以肯定是返回首个只出现一次的字符
                return c;
            }
        }
        return ' ';
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abbccdeff"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "ccdd"\n
 * // @lcpr case=end
 * 
 */

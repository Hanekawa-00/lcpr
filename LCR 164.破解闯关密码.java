/*
 * @lc app=leetcode.cn id=LCR 164 lang=java
 * @lcpr version=30204
 *
 * [LCR 164] 破解闯关密码
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public String crackPassword(int[] password) {
        if (password == null || password.length == 0) {
            return "";
        }
        String[] passStr = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            passStr[i] = String.valueOf(password[i]);
        }
        // 使用比较器规则来自动排序
        Arrays.sort(passStr, (s1, s2) -> {
            String order1 = s1 + s2;
            String order2 = s2 + s1;
            return order1.compareTo(order2);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String pass : passStr) {
            stringBuilder.append(pass);
        }
        return stringBuilder.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [15, 8, 7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0, 3, 30, 34, 5, 9]\n
 * // @lcpr case=end
 * 
 */

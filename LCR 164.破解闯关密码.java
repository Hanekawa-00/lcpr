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
import java.util.Comparator;

class Solution {
    public String crackPassword(int[] password) {
        String[] arr = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            arr[i] = String.valueOf(password[i]);
        }
        // 使用快速排序是不是更好？
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //先相加再比较相加后的值
                String ab = a + b;
                String ba = b + a;
                return ab.compareTo(ba);// 使用字符串字典升序来排序
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr) {
            stringBuilder.append(s);
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

/*
 * @lc app=leetcode.cn id=LCR 192 lang=java
 * @lcpr version=30204
 *
 * [LCR 192] 把字符串转换成整数 (atoi)
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        int index = 0; // 遍历索引,指向下一个目标字符
        int sign = 1; // 符号位，默认为1
        int result = 0;
        // 跳过空格
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        // 确认符号位
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        // 开始遍历
        // 退出条件是
        while (index < len && Character.isDigit(str.charAt(index))) {
            int curr = str.charAt(index) - '0';// -'0'可以将字符转化为数字？
            /*
             * 在将当前数字 curr 加入 result 之前，进行溢出检查。
             * result > Integer.MAX_VALUE / 10: 如果 result 已经大于 Integer.MAX_VALUE / 10，那么再乘以
             * 10 肯定会溢出。
             * result == Integer.MAX_VALUE / 10 && curr > 7: 如果 result 等于 Integer.MAX_VALUE
             * / 10，那么还需要看 curr 是否大于 7。因为 Integer.MAX_VALUE 的最后一位是 7。
             */
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && curr > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + curr;
            index++;
        }
        return result * sign;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "42"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "   -42"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "4193 with words"\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=LCR 133 lang=java
 * @lcpr version=30204
 *
 * [LCR 133] 位 1 的个数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        // 当 n 不为 0 时，说明 n 中至少还有一位是 1 (对于负数，其补码表示)
        // 使用无符号右移 (>>>) 可以确保在处理负数时，左边补 0，
        // 从而使循环在处理完所有32位后，n 最终变为 0。
        while (n != 0) {
            // 检查最低位是否为 1
            // (n & 1) 的结果是 0 或 1,这样可以避免使用取模比较
            if ((n & 1) == 1) {
                count++;
            }
            // 无符号右移一位，处理下一位
            n = n >>> 1;
        }
        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 11 (控制台输入 00000000000000000000000000001011)\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 128 (控制台输入 00000000000000000000000010000000)\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // -3）\n
 * // @lcpr case=end
 * 
 */

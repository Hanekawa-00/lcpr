/*
 * @lc app=leetcode.cn id=LCR 190 lang=java
 * @lcpr version=
 *
 * [LCR 190] 加密运算
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int encryptionCalculate(int dataA, int dataB) {
        // 将 dataA 和 dataB 赋值给临时变量 a 和 b，方便后续迭代
        // 在每次迭代中，a 存储当前的“无进位和”，b 存储当前的“进位”
        int a = dataA;
        int b = dataB;

        // 当 b (相当于进位) 不为 0 时，循环进行
        // 循环的目的是将进位不断地加到无进位和上，直到没有进位为止
        while (b != 0) {
            // 步骤 1: 计算进位 (carry)
            // (a & b) 找出 a 和 b 中都为 1 的位，这些位会产生进位
            // << 1 将进位左移一位，放到下一位进行处理
            int carry = (a & b) << 1;

            // 步骤 2: 计算当前位的和 (sum without carry)
            // a ^ b 异或操作，实现无进位加法
            // 结果存储在 a 中，作为下一轮的“无进位和”
            a = a ^ b;

            // 步骤 3: 更新 b 为当前的进位
            // 将计算出的进位赋值给 b，作为下一轮循环的加数
            // 下一轮循环实际上是计算 (a ^ b) + ((a & b) << 1)
            b = carry;
        }

        // 当 b (进位) 为 0 时，循环结束
        // 此时 a 中存储的就是最终的无进位和，也就是最终的和
        return a;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 5\n-1\n
 * // @lcpr case=end
 * 
 */

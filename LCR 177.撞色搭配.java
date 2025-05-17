/*
 * @lc app=leetcode.cn id=LCR 177 lang=java
 * @lcpr version=30204
 *
 * [LCR 177] 撞色搭配
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public int[] sockCollocation(int[] sockets) {
        int xorSum = 0;// 两个撞色所异或的结果
        for (int num : sockets) {
            xorSum ^= num;
        }
        // xorSum & 补码(-xorSum) 可以得到 xorSum 的二进制表示中最低位的1所对应的值（不是最低位也是可以的，只要这一位是1就可以）
        int diffBit = xorSum & (-xorSum);
        int num1 = 0;
        int num2 = 0;
        // 将两个不同的数字分在不同的两组，因为只要这一个判断条件就可以区分他们
        // 至于其他数字，两个相同的数字num & diffBit的结果是同样的，所以能够分到同一组
        // 所以每个组分别异或就能找到唯一数
        for (int num : sockets) {
            if ((num & diffBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[] { num1, num2 };
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4, 5, 2, 4, 6, 6]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1, 2, 4, 1, 4, 3, 12, 3]\n
 * // @lcpr case=end
 * 
 */

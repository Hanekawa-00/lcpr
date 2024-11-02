/*
 * @lc app=leetcode.cn id=134 lang=java
 * @lcpr version=30204
 *
 * [134] 加油站
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {

    /**
     * 重点：结合两数组，环形数组
     * 
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 这个数组的意义是作为净油量=在该加油站加的油-下一段路要用掉的油
        int[] s = new int[gas.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = gas[i] - cost[i];
        }
        // 遍历最大长度
        int n = s.length;
        // 若进入下一次循环，则未找到答案，即遇到一个负数很大,在r位置
        for (int l = 0, r = 0, sum; l < n; l = r + 1, r = l) {
            sum = 0;
            while (sum + s[r % n] >= 0) {// 取模模拟环形数组（因为r很有可能超过索引，一旦不是从0出发）
                if (r - l + 1 == n) {
                    return l;// 说明l这个位置可行（能够绕一圈返回）
                }
                sum += s[r % n];
                r++;// r是变量一直向右
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n[3,4,5,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,4]\n[3,4,3]\n
 * // @lcpr case=end
 * 
 */

/*
 * @lc app=leetcode.cn id=287 lang=java
 * @lcpr version=30204
 *
 * [287] 寻找重复数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // 阶段一： 找到快慢指针的相遇点 (环检测)
        int tortoise = nums[0]; // 慢指针 (龟)
        int hare = nums[0];    // 快指针 (兔)
        do {
            tortoise = nums[tortoise]; // 慢指针走一步
            hare = nums[nums[hare]];    // 快指针走两步
        } while (tortoise != hare); // 当快慢指针相遇时停止

        // 阶段二： 找到环的入口点 (重复数字)
        tortoise = nums[0]; // 将慢指针重置到起点
        while (tortoise != hare) {
            tortoise = nums[tortoise]; // 慢指针走一步
            hare = nums[hare];        // 快指针也走一步 (同步走)
        }

        return hare; // 或者 return tortoise;  它们相遇的地方就是环的入口点，即重复数字
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3,4,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,1,3,4,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,3,3,3,3]\n
 * // @lcpr case=end
 * 
 */

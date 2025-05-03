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
        // 将这个数组看作是一个链表
        int slow = 0;
        int fast = 0;
        // 参照循环链表的鸽巢理论，必定存在环,环的入口就是重复元素
        // 即转化为寻找链表的环入口
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
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

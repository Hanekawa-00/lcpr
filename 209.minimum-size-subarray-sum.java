/*
 * @lc app=leetcode.cn id=209 lang=java
 * @lcpr version=30204
 *
 * [209] 长度最小的子数组
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 寻找最短子数组和大于target
     * 
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;// 初始化ans的值
        int sum = 0;// 初始化和（子数组的和）
        // 1.寻找子数组，r向右移动
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            //2. 题目条件
            if (sum >= target) {
                //4. 尝试用和减去最左边的数与target比较，如果大于则子数组可以缩短
                //tip：为什么要先执行这步？
                //因为r一直是向右移动的，如果突然移到一个特别大的数（相对），l就显的多余
                while (sum - nums[l] >= target) {
                    sum -= nums[l];
                    l++;// l边界向右移动
                }
                //3.
                answer = Math.min(answer, r - l + 1);
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 7\n[2,3,1,2,4,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n[1,4,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 11\n[1,1,1,1,1,1,1,1]\n
 * // @lcpr case=end
 * 
 */

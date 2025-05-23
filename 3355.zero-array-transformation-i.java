/*
 * @lc app=leetcode.cn id=3355 lang=java
 * @lcpr version=30204
 *
 * [3355] 零数组变换 I
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        if (nums == null || nums.length == 0) {
            // 边界条件：nums 为空数组，直接返回 true
            return true;
        }
        
        int n = nums.length;  // nums 的长度
        int[] diff = new int[n];  // 初始化差分数组，大小为 n
        
        // 第一步：处理所有查询，使用差分数组
        for (int[] query : queries) {
            int li = query[0];
            int ri = query[1];
            diff[li] += 1;  // 在 li 处增加 1
            if (ri + 1 < n) {  // 如果 ri+1 在数组范围内，才减 1
                diff[ri + 1] -= 1;
            }
        }
        
        // 第二步：计算差分数组的前缀和，得到 cover 数组
        int[] cover = new int[n];  // cover 数组用于存储最终覆盖次数
        cover[0] = diff[0];  // 第一个元素直接赋值
        for (int j = 1; j < n; j++) {
            cover[j] = cover[j - 1] + diff[j];  // 前缀和计算
        }
        
        // 第三步：遍历 nums 数组，验证每个位置
        for (int j = 0; j < n; j++) {
            if (cover[j] < nums[j]) {
                // 如果覆盖次数小于 nums[j]，则无法减到零
                return false;
            }
            // cover[j] >= nums[j] 表示可以选择子集来精确减 nums[j] 次
        }
        
        // 所有位置都满足条件，返回 true
        return true;
    }
}

// @lc code=end

/*
 * // @lcpr case=start
 * // [1,0,1]\n[[0,2]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,3,2,1]\n[[1,3],[0,2]]\n
 * // @lcpr case=end
 * 
 */

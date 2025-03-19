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
          // 不使用四则运算实现两数相加
          while (dataB != 0) {
            // 计算无进位和
            int sum = dataA ^ dataB;
            
            // 计算进位
            int carry = (dataA & dataB) << 1;
            
            // 更新 dataA 和 dataB 用于下一轮计算
            dataA = sum;
            dataB = carry;
        }
        
        return dataA;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n-1\n
// @lcpr case=end

 */


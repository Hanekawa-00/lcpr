/*
 * @lc app=leetcode.cn id=LCR 152 lang=java
 * @lcpr version=30204
 *
 * [LCR 152] 验证二叉搜索树的后序遍历序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /**
     * 二叉搜索树严格定义左子树全部大于root。，右子树严格小于root。
     * 后序遍历结果中，root必定是最后一个元素
     * 以此为突破口来验证
     * 
     * @param postorder
     * @return
     */
    public boolean verifyTreeOrder(int[] postorder) {
        if (postorder == null || postorder.length <= 1) {
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 设置该子树的root值
        int rootVal = postorder[end];
        // 找到首个大于根节点的值所在索引
        // 这个子节点就是左右子树的分界线(如果是搜索树)
        int rightStart = start;
        while (rightStart < end && postorder[rightStart] < rootVal) {
            rightStart++;
        }
        // 检查右子树是否全部大于root值（这里左子树已经遍历过了）
        for (int i = rightStart; i < end; i++) {
            if (postorder[i] < rootVal) {
                return false;// 违背搜索树的定义
            }
        }
        // 递归判断左右子树
        return verify(postorder, start, rightStart - 1) && verify(postorder, rightStart, end - 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,9,6,5,8]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,6,5,9,8]\n
 * // @lcpr case=end
 * 
 */

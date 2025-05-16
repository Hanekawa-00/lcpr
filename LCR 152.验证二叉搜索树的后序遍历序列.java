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

    public boolean verifyTreeOrder(int[] postorder) {
        // 二叉搜索树的性质是左子树所有值都小于根节点，右子树则相反
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int rootVal = postorder[j];
        int m = i;// 分割点
        while (postorder[m] < rootVal) {
            m++;
        }
        int p = m;
        // 初步判断,验证右子树，以当前rootVal为根节点的二叉树是否满足搜索二叉树的性质
        while (p < j) {
            if (postorder[p] < rootVal) {
                return false;
            }
            p++;
        }
        // 验证左右子树
        return recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
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

/*
 * @lc app=leetcode.cn id=LCR 120 lang=java
 * @lcpr version=30204
 *
 * [LCR 120] 寻找文件副本
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    /**
     * 文件id保持在documents.length之间
     * 先尝试复位id到正确的位置，如果在复位的过程中出现有与该位置维护相同id的情况下说明找到了重复数据
     * 
     * @param documents
     * @return
     */
    public int findRepeatDocument(int[] documents) {
        int i = 0;
        while (i < documents.length) {
            if (i == documents[i]) {
                i++;
                continue;
            }
            // 发现重复数据
            if (documents[documents[i]] == documents[i]) {
                return documents[i];
            }
            // 跳转i，然后交换索引位置上的数字
            int tmp = documents[i];
            documents[i] = documents[tmp];
            documents[tmp] = tmp;
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2, 5, 3, 0, 5, 0]\n
 * // @lcpr case=end
 * 
 */

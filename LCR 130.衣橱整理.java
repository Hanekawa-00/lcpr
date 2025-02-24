/*
 * @lc app=leetcode.cn id=LCR 130 lang=java
 * @lcpr version=30204
 *
 * [LCR 130] 衣橱整理
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int wardrobeFinishing(int m, int n, int cnt) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, cnt, visited);
    }

    /**
     * @param i       当前横坐标
     * @param j       纵坐标
     * @param m
     * @param n
     * @param cnt
     * @param visited 维护每个格子的访问情况
     * @return
     */
    private int dfs(int i, int j, int m, int n, int cnt, boolean[][] visited) {
        // 边界检查
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        // 如果已经访问或者不满足条件则退出（因为是返回int类型，所以在不影响结果的条件下使用0）
        if (visited[i][j] || (digitSum(i) + digitSum(j)) > cnt) {
            return 0;
        }
        // 标记为已访问
        visited[i][j] = true;
        // 计数，并且向右边和下边继续搜索
        return 1 + dfs(i + 1, j, m, n, cnt, visited) + dfs(i, j + 1, m, n, cnt, visited);
    }

    /**
     * 计算各位数之和
     * 
     * @param x
     * @return
     */
    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n7\n5\n
 * // @lcpr case=end
 * 
 */

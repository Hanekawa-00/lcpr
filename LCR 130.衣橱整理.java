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
        return dfs(0, 0, m, n, visited, cnt);
    }

    public int dfs(int i, int j, int m, int n, boolean[][] visited, int cnt) {
        if (i >= m || j >= n || visited[i][j]) {
            return 0;
        }
        if (digitSum(i) + digitSum(j) > cnt) {
            return 0;
        }
        visited[i][j] = true;
        // 这里与回溯的区别就是这题指定出发点，而不需要一次次尝试
        return 1 + dfs(i + 1, j, m, n, visited, cnt) + dfs(i, j + 1, m, n, visited, cnt);
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10; // 取个位数
            num /= 10;
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

/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30204
 *
 * [207] 课程表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表，用来保存先修课程指向后修课程的有向边（对应关系，可以是一对多，即一个课程可以是多个课程的先修课程）
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        // 入度数组，用来保存对应课程的先修课程数量
        int[] inDegree = new int[numCourses];
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];// 后修课程 ‘a’
            int preCourse = prerequisite[1]; // 先修课程’b'
            adj.get(preCourse).add(course);// 从先修课程b 向 后修课程添加有向边
            inDegree[course]++;// 后修课程a入度加1
        }
        // 保存不需要先修课程的课程队列，即图的头节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            // 遍历该节点的所有有向边
            for (int neighbor : adj.get(course)) {
                // 减少一个先修课程数量
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n[[1,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[[1,0],[0,1]]\n
 * // @lcpr case=end
 * 
 */

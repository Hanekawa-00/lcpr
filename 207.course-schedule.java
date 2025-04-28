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
        // 存储以课程i为前置课程的列表（i是前置课程）
        List<List<Integer>> prereqListMap = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            prereqListMap.add(new ArrayList<>());
        }
        // 存储课程i的入度数量（前置课程数量）
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int preCourse = prereq[1];
            // course以preCourse作为前置课程
            prereqListMap.get(preCourse).add(course);
            inDegree[course]++;
        }
        // 用来维护前置课程已经修完的课程队列（当然也包括没有前置课程的课程）
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int completedCount = 0;
        while (!queue.isEmpty()) {
            // 出队标记已修
            int curr = queue.poll();
            // 更新以curr为前置课程的课程
            List<Integer> reqList = prereqListMap.get(curr);
            for (Integer req : reqList) {
                // 前置课程已修，入度减一
                inDegree[req]--;
                if (inDegree[req]== 0) {
                    queue.offer(req);
                }
            }
            completedCount ++;
        }
        return completedCount == numCourses;
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

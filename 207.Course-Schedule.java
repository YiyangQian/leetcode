/*
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (37.75%)
 * Total Accepted:    213.5K
 * Total Submissions: 565.7K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] neighbors = new boolean[numCourses][numCourses];
        for(int[] pair : prerequisites) {
            neighbors[pair[0]][pair[1]] = true;
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses;  i++) {
            if(!dfs(neighbors, visiting, visited, i)) return false;
        }
        return true;
    }

    public boolean dfs(boolean[][] neighbors, boolean[] visiting, boolean[] visited, int cur) {
        if (visited[cur]) {
            return true;
        } else if (visiting[cur]) {
            return false;
        } else {
            visiting[cur] = true;
        }

        for (int i = 0; i < neighbors[cur].length; i++) {
            if (neighbors[cur][i]) {
                if (!dfs(neighbors, visiting, visited, i)) return false;
            }
        }
        visited[cur] = true;
        return true;
    }
}

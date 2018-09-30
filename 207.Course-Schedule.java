class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //direction is pre course to cur course
        int[] indegree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[cur] += 1;
            isPre[pre][cur] = true;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (isPre[cur][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
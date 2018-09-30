class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //direction is from pre to cur course
        int[] indegree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[course]++;
            isPre[pre][course] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index] = cur;
            index++;
            for (int i = 0; i < numCourses; i++) {
                if (isPre[cur][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        if (index != numCourses) return new int[0];
        return res;
    }
}

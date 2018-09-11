class Solution {
    public int uniquePaths(int m, int n) {
        int[][] track = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) track[i][0] = 0;
        for (int j = 0; j < n + 1; j++) track[0][j] = 0;
        track[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!(i == 1 && j == 1)) {
                    track[i][j] = track[i - 1][j] + track[i][j - 1];
                }
            }
        }
        return track[m][n];
    }
}

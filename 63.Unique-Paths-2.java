class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] track = new int[rowNum + 1][colNum + 1];
        for (int i = 0; i < rowNum + 1; i++) track[i][0] = 0;
        for (int j = 0; j < colNum + 1; j++) track[0][j] = 0;
        for (int i = 1; i < rowNum +1; i++) {
            for (int j = 1; j < colNum + 1; j++) {
                if (i == 1 && j == 1) {
                    track[i][j] = (obstacleGrid[0][0] == 1) ? 0 : 1;
                } else if (obstacleGrid[i - 1][j - 1] != 1) {
                    int up = (i >= 2 && j >= 1 && obstacleGrid[i - 2][j - 1] == 1) ? 0 : track[i - 1][j];
                    int left = (i >= 1 && j >= 2 && obstacleGrid[i - 1][j - 2] == 1) ? 0 : track[i][j - 1];
                    track[i][j] = up + left;
                } else {
                    track[i][j] = 0;
                }
            }
        }
        return track[rowNum][colNum];
    }
}
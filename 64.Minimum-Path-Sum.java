class Solution {
    public int minPathSum(int[][] grid) {
        int[][] track = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    track[i][j] = grid[i][j];
                } else {
                    int top = (i >= 1) ? track[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j >= 1) ? track[i][j - 1] : Integer.MAX_VALUE;
                    track[i][j] = Math.min(top, left) + grid[i][j];                
                }
            }
        }
        return track[track.length - 1][track[0].length - 1];
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int m = x + dirs[i][0];
            int n = y + dirs[i][1];
            if (m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1') {
                dfs(grid, m, n);
            }
        }
    }
}

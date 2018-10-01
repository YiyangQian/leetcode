class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int lenAsLUConer = getLength(matrix, i, j);
                    max = Math.max(max, lenAsLUConer);
                }
            }
        }
        return max * max;
    }
    
    public int getLength(char[][] matrix, int x, int y) {
        int len = 1;
        boolean flag = true;
        while (flag) {
            for (int i = x; i <= x + len; i++) {
                if (i >= matrix.length || y + len >= matrix[0].length || matrix[i][y + len] == '0') flag = false;
            }           
            for (int j = y; j <= y + len; j++) {
                if (j >= matrix[0].length || x + len >= matrix.length || matrix[x + len][j] == '0') flag = false;
            }
            if (flag) {
                len++;
            }
        }
        return len;
    }
}

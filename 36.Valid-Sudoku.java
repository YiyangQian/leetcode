class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<Character>();
            Set<Character> colSet = new HashSet<Character>();
            Set<Character> gridSet = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) return false;
                if (board[j][i] != '.' && !colSet.add(board[j][i])) return false;
                
                int rowIndex = (i / 3) * 3 + j / 3;
                int colIndex = (i % 3) * 3 + j % 3;
                if (board[rowIndex][colIndex] != '.' && !gridSet.add(board[rowIndex][colIndex])) return false;
             }
        }
        return true;
    } 
}
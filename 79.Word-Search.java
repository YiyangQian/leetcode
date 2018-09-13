class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean curRes = helper(board, word, i, j, 0, isVisited);
                if (curRes) return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int i, int j, int curIndex, boolean[][] isVisited) {
        if (curIndex == word.length())
            return true;
        boolean nextMove;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] || board[i][j] != word.charAt(curIndex)) {
            return false;
        } else {
            isVisited[i][j] = true;
            nextMove = helper(board, word, i + 1, j, curIndex + 1, isVisited)
            || helper(board, word, i - 1, j, curIndex + 1, isVisited)
            || helper(board, word, i, j + 1, curIndex + 1, isVisited)
            || helper(board, word, i, j - 1, curIndex + 1, isVisited);
            isVisited[i][j] = false;
        }
        return nextMove;
    }
}
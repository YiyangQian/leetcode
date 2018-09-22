class Solution {
    public void gameOfLife(int[][] board) {
        // rules:
        // 1 1 with count (0, 1, 4, 5, 6, 7, 8) will be 0, noted as 2 in the first
        // iteration
        // 2 1 with count (2, 3) will be 1
        // 3 0 with count (3) will be 1, noted as -1 in the first iteration
        // 4 0 with count (0, 1, 2, 4, 5, 6, 7, 8) will be 0
        // the key part is to use on number to denote both next state and current state,
        // and for current state we only care about
        // how many 1 aroud, so if original 1 we note it as 2 (treated as 1), if 0 note
        // as -1 (treated as 0)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = getCount(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int getCount(int[][] board, int x, int y) {
        int[][] dirs = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            int movedX = x + dirs[i][0];
            int movedY = y + dirs[i][1];
            if (movedX >= 0 && movedX < board.length && movedY >= 0 && movedY < board[0].length
                    && board[movedX][movedY] > 0)
                count++;
        }
        return count;
    }
}
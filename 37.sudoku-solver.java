
/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {

    // scene different from N-queen as there u jump to next row after placing a
    // queen in a clm
    // but here u want to go to next clm

    // beats: 81%

    public boolean solveSudoku(char[][] board) {
        // find next empty place
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') {
                    for (int i = 1; i <= 9; i++) {
                        char dgt = (char) (i + '0');
                        if (isSafeToPlace(dgt, board, r, c)) {
                            board[r][c] = dgt;
                            if (solveSudoku(board))
                                return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafeToPlace(char i, char[][] board, int row, int col) {
        for (int c = 0; c < board.length; c++)
            if (board[row][c] == i)
                return false;

        for (int r = 0; r < board.length; r++)
            if (board[r][col] == i)
                return false;

        int dc = col - col % 3;
        int dr = row - row % 3;

        for (int r = dr; r < dr + 3; r++)
            for (int c = dc; c < dc + 3; c++)
                if (board[r][c] == i)
                    return false;

        return true;
    }
}
// @lc code=end

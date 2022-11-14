import java.util.*;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {

    // TC: 6n
    // private boolean isSafeToPlace(boolean[][] board, int row, int col) {
    // if (board[row][col]) // a queen already here
    // return false;

    // // check col O(n)
    // for (int i = 0; i < board.length; i++)
    // if (board[i][col])
    // return false;

    // // check row O(n)
    // for (int i = 0; i < board.length; i++)
    // if (board[row][i])
    // return false;

    // // check left-right-up diagonal O(n)
    // for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
    // if (board[i][j])
    // return false;

    // // check left-right-down diagonal O(n)
    // for (int i = row, j = col; i < board.length && j < board.length; i++, j++)
    // if (board[i][j])
    // return false;

    // // check right-left-up diagonal O(n)
    // for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
    // if (board[i][j])
    // return false;

    // // check right-left-down diagonal O(n)
    // for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
    // if (board[i][j])
    // return false;

    // return true;
    // }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();

        boolean rPos[] = new boolean[n];
        boolean cPos[] = new boolean[n];
        boolean lr[] = new boolean[2 * n - 1];
        boolean rl[] = new boolean[2 * n - 1];

        solveNQueens(board, 0, result, rPos, cPos, lr, rl);
        return result;
    }

    private boolean isSafeToPlace(int r, int c, boolean[] rPos, boolean[] cPos, boolean[] lr, boolean[] rl, int n) {
        // check if any queen at same row
        if (rPos[r])
            return false;

        // if a queen on same column
        if (cPos[c])
            return false;

        // to get logic behind below:
        // https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14

        // any queen at right-to-left diagonal
        if (rl[r + c])
            return false;

        // any queen at left-to-right diagonal
        if (lr[(n - 1) + (c - r)])
            return false;

        return true;
    }

    // Time: 30.84% Space: 44%
    // public void solveNQueens(boolean[][] board, int col, List<List<String>>
    // result) {
    // if (col == board.length) {
    // List<String> rowPos = new ArrayList<>();
    // for (int row = 0; row < board.length; row++) {
    // String pos = "";
    // for (int c = 0; c < board.length; c++)
    // if (board[row][c])
    // pos += "Q";
    // else
    // pos += ".";
    // rowPos.add(pos);
    // }
    // result.add(rowPos);
    // return;
    // }
    // for (int row = 0; row < board.length; row++) {
    // if (isSafeToPlace(board, row, col)) {
    // board[row][col] = true;
    // solveNQueens(board, col + 1, result);
    // // resetting made it ready for back-track, so if 1 solution found then also
    // it
    // // tries for another solution
    // board[row][col] = false;
    // }
    // }
    // }

    // Time: beats 91% space: beats 90%
    public void solveNQueens(boolean[][] board, int col, List<List<String>> result, boolean[] rPos, boolean[] cPos,
            boolean[] lr, boolean[] rl) {
        if (col == board.length) {
            List<String> rowPos = new ArrayList<>();
            for (int row = 0; row < board.length; row++) {
                String pos = "";
                for (int c = 0; c < board.length; c++)
                    if (board[row][c])
                        pos += "Q";
                    else
                        pos += ".";
                rowPos.add(pos);
            }
            result.add(rowPos);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafeToPlace(row, col, rPos, cPos, lr, rl, board.length)) {
                board[row][col] = true;

                rPos[row] = true;
                cPos[col] = true;
                rl[row + col] = true;
                lr[(board.length - 1) + (col - row)] = true;

                solveNQueens(board, col + 1, result, rPos, cPos, lr, rl);
                // resetting made it ready for back-track, so if 1 solution found then also it
                // tries for another solution

                board[row][col] = false;
                rPos[row] = false;
                cPos[col] = false;
                rl[row + col] = false;
                lr[(board.length - 1) + (col - row)] = false;
            }
        }
    }

    // public static void main(String[] args) {
    // Solution51 s = new Solution51();
    // System.out.println(s.solveNQueens(4));
    // }
}
// @lc code=end

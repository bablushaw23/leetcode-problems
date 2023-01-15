import java.lang.annotation.Retention;
import java.util.*;

/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        if (obstacleGrid[0][0] == 1)
            return 0;

        // init memo
        int[][] memo = new int[n][m];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return mazeObstacles(n - 1, m - 1, obstacleGrid, memo);
    }

    int mazeObstacles(int n, int m, int[][] mat, int[][] memo) {
        // base case
        if (n == 0 && m == 0)
            return 1;
        // -1 case
        if (n < 0 || m < 0)
            return 0;
        // obstacle case
        if (mat[n][m] == 1)
            return 0;
        // check if already solved
        if (memo[n][m] != -1)
            return memo[n][m];
        int top, left;
        top = mazeObstacles(n - 1, m, mat, memo);
        left = mazeObstacles(n, m - 1, mat, memo);
        // save into memo before return

        return memo[n][m] = (top + left);
    }

}
// @lc code=end

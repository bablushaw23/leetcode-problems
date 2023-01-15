import java.util.Arrays;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {

    // space-optimized
    public int uniquePaths(int m, int n) {
        int[] previousRow = new int[n];
        int[] currentRow = new int[n];
        currentRow[0] = 1; // base case
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int down = 0, right = 0;
                if (i > 0)
                    down = previousRow[j];
                if (j > 0)
                    right = currentRow[j - 1];
                currentRow[j] = down + right;
            }
            previousRow = currentRow;
            currentRow = new int[n];
        }
        return previousRow[n - 1];
    }

    /**
     * Tabulized
     * public int uniquePaths(int m, int n) {
     * int[][] memo = new int[m][n];
     * memo[0][0] = 1; // base case
     * for (int i = 0; i < m; i++) {
     * for (int j = 0; j < n; j++) {
     * if (i == 0 && j == 0)
     * continue;
     * int down = 0, right = 0;
     * if (i > 0)
     * down = memo[i - 1][j];
     * if (j > 0)
     * right = memo[i][j - 1];
     * memo[i][j] = down + right;
     * }
     * }
     * return memo[m - 1][n - 1];
     * }
     */

    /**
     * memoized
     * 
     * public int uniquePaths(int m, int n) {
     * int[][] memo = new int[m][n];
     * for (int[] row : memo)
     * Arrays.fill(row, -1);
     * return calcUniquePaths(m - 1, n - 1, memo);
     * }
     * 
     * private int calcUniquePaths(int m, int n, int[][] memo) {
     * // base case
     * if (m == 0 && n == 0)
     * return 1;
     * if (m < 0 || n < 0)
     * return 0;
     * if (memo[m][n] != -1)
     * return memo[m][n];
     * // step 2
     * int left = calcUniquePaths(m - 1, n, memo);
     * int up = calcUniquePaths(m, n - 1, memo);
     * memo[m][n] = left + up;
     * return memo[m][n];
     * }
     */
}
// @lc code=end

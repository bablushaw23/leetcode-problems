/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class Solution {
    // beats 98% TC: O(n)
    public int[] findDiagonalOrder(int[][] mat) {
        int x = 0, y = 0; // x=row, y=clm
        int maxX = mat.length - 1;
        int maxY = mat[0].length - 1;
        int[] diagonal = new int[mat.length * mat[0].length];
        int diInd = 0;
        boolean isUp = true;
        while (diInd < diagonal.length) {
            diagonal[diInd++] = mat[x][y];
            if (isUp) {
                if (x == 0) {
                    isUp = false;
                    if (y < maxY)
                        y++;
                    else
                        x++;
                } else if (y == maxY) {
                    isUp = false;
                    x++;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (y == 0) {
                    isUp = true;
                    if (x < maxX)
                        x++;
                    else
                        y++;
                } else if (x == maxX) {
                    isUp = true;
                    y++;
                } else {
                    x++;
                    y--;
                }
            }
        }
        return diagonal;
    }
}
// @lc code=end

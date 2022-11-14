import java.util.HashSet;

/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution73 {

    // question is asking for constant space soln but I able to came up with O(m+n)
    // space. Implementing it
    public void setZeroes(int[][] matrix) {
        int[] track0Row = new int[matrix.length];
        int[] track0Col = new int[matrix[0].length];

    }

    public static void main(String[] args) {
        Solution73 s = new Solution73();
        int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        s.setZeroes(matrix);
    }
}
// @lc code=end

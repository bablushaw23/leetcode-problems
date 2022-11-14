/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int n) {
        if (n == 1 || n >= s.length())
            return s;
        char[] chars = s.toCharArray();
        // int maxCol = chars.length / n + chars.length % n;
        int maxCol = chars.length;
        // System.out.println(maxCol);
        char[][] matrix = new char[n][maxCol];
        int col = 0, charIndex = 0;
        whileLoop: while (true) {
            for (int row = 0; row < n; row++) {
                // System.out.print(chars[charIndex]);
                matrix[row][col] = chars[charIndex++];
                if (charIndex == chars.length) {
                    break whileLoop;
                }
            }
            col++;
            for (int row = n - 2; row > 0; row--) {
                // System.out.print(chars[charIndex]);
                matrix[row][col++] = chars[charIndex++];
                if (charIndex == chars.length)
                    break whileLoop;
            }
        }
        charIndex = 0;
        StringBuilder result = new StringBuilder();
        forloop: for (int row = 0; row < n; row++)
            for (col = 0; col < maxCol; col++)
                if (matrix[row][col] > 0) {
                    result.append(matrix[row][col]);
                    charIndex++;
                    if (charIndex == chars.length)
                        break forloop;
                }
        return result.toString();
    }
}
// @lc code=end

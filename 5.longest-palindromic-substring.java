/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    int start, size;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            checkPelindrome(i, i, s); // for odd length pelindrome substring
            checkPelindrome(i, i + 1, s); // for even length pelindrome substring
        }
        return s.substring(start, start + size);
    }

    public void checkPelindrome(int j, int k, String s) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) { // check pelindrome
            j--;
            k++;
        } // pelindrome check part ends here

        if (size < k - j - 1) { // compare pelindrome length with max
            start = j + 1;
            size = k - j - 1;
        }
    }
}
// @lc code=end

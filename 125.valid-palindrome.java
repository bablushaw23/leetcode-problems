/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    // beats 12%
    // public boolean isPalindrome(String s) {
    // // removing noise and keeping only letters
    // String letters = "";
    // for (char c : s.toCharArray()) {
    // if (Character.isDigit(c) || Character.isLetter(c))
    // letters += String.valueOf(c);
    // }
    // letters = letters.toLowerCase();
    // return checkIfPelindrome(letters);
    // }

    // public boolean checkIfPelindrome(String letters) {
    // int size = letters.length();
    // if (size < 2)
    // return true;
    // else if (size == 2)
    // return letters.charAt(0) == letters.charAt(1);
    // if (letters.charAt(0) == letters.charAt(size - 1))
    // return checkIfPelindrome(letters.substring(1, size - 1));
    // else
    // return false;

    // }

    // beats 50%
    public boolean isPalindrome(String s) {
        // removing noise and keeping only letters
        StringBuffer letters = new StringBuffer();
        for (char c : s.toCharArray()) { // O(n)
            if (Character.isDigit(c) || Character.isLetter(c))
                letters.append(String.valueOf(c));
        }
        return checkIfPelindrome(letters.toString().toLowerCase(), 0, letters.length() - 1); // O(n/2)
    }

    // O(n/2)
    public boolean checkIfPelindrome(String letters, int l, int r) {
        if (r <= l)
            return true;
        if (letters.charAt(l) == letters.charAt(r))
            return checkIfPelindrome(letters, l + 1, r - 1);
        else
            return false;

    }
}
// @lc code=end

package recursion;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class test {
    /*
     * @lc app=leetcode id=125 lang=java
     *
     * [125] Valid Palindrome
     */

    // @lc code=start
    class Solution {
        public boolean isPalindrome(String s) {
            // removing noise and keeping only letters
            String letters = "";
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c) || Character.isLetter(c))
                    letters += String.valueOf(c);
            }
            letters = letters.toLowerCase();
            return checkIfPelindrome(letters);
        }

        public boolean checkIfPelindrome(String letters) {
            int size = letters.length();
            if (size < 2)
                return true;
            else if (size == 2)
                return letters.charAt(0) == letters.charAt(1);
            if (letters.charAt(0) == letters.charAt(size - 1))
                return checkIfPelindrome(letters.substring(1, size - 1));
            else
                return false;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
// @lc code=end

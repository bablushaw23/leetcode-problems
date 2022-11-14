/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        int p = 0, c = x;
        ;
        while (x > 0) {
            p = p * 10 + x % 10;
            x = x / 10;
        }
        return c == p;
    }
}
// @lc code=end

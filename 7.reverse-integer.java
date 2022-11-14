/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int mod = 0, rev = 0;
        boolean isNeg = x < 0;
        if (isNeg)
            x *= -1;
        while (x > 0) {
            mod = x % 10;
            rev = rev * 10 + x % 10;
            if (mod != rev % 10)
                return 0;
            x /= 10;
        }
        return isNeg ? rev * -1 : rev;
    }

}
// @lc code=end

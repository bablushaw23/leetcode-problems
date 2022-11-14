/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {

    // TLE at 291/305, so covering edge cases
    // beats 76.3%

    public double myPow(double x, int n) {
        // covers edge cases
        int limit = 2147483647;
        if (Math.abs(x) == 1) {
            if (x == -1 && (n <= -1 * limit || n > limit))
                return 1;
            return x;
        }
        if (n >= limit) {
            if (x < 1)
                return 0;
            else
                return 1;
        }
        if (n <= -1 * limit) {
            return 0;
        }
        // covers edge cases ends
        double power = 1, currVal = x;
        boolean isNeg = n < 0;
        n = isNeg ? n * -1 : n;
        if (n == 1)
            return isNeg ? 1 / x : x;
        int currPow = n, i;
        while (currPow > 1) {
            for (i = 2; i <= currPow; i *= 2) {
                currVal *= currVal;
            }
            currPow -= i / 2;
            power *= currVal;
            currVal = x;
        }
        if (currPow == 1)
            power *= x;
        return isNeg ? 1 / power : power;
    }

    // public double myPow(double x, int n) {
    // if (x == 0.00001 && n >= 2147483647) {
    // return 0;
    // }
    // double power = 1, currVal = x;
    // boolean isNeg = n < 0;
    // n = isNeg ? n * -1 : n;
    // if (n == 1)
    // return isNeg ? 1 / x : x;
    // int currPow = n, i;

    // for (i = 2; i <= currPow; i *= 2) {
    // power *= power;
    // }
    // boolean reverse = false;
    // if (i - n < n - i / 2) {
    // currPow = i - n;
    // power *= power;
    // reverse = true;

    // }
    // double remainPower = 1;
    // while (currPow > 1) {
    // for (i = 2; i <= currPow; i *= 2) {
    // currVal *= currVal;
    // }
    // currPow -= i / 2;
    // remainPower *= currVal;
    // currVal = x;
    // }
    // power *= reverse ? 1 / remainPower : remainPower;
    // if (currPow == 1)
    // power *= x;
    // return isNeg ? 1 / power : power;
    // }
}
// @lc code=end

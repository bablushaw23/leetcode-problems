/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int integer = 0;
        int prev = 0;
        s = s.trim();
        if (s.equals(""))
            return 0;

        char[] chars = s.toCharArray();
        boolean isNeg = chars[0] == '-';
        int i = 0;
        if (isNeg || chars[0] == '+')
            i = 1;
        for (; i < chars.length; i++) {
            if ((chars[i] - '0') > 9 || (chars[i] - '0') < 0)
                break;
            prev = integer;
            integer = integer * 10 + (chars[i] - '0');
            if (prev > integer || integer % 10 != (chars[i] - '0'))
                if (isNeg)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
        }
        return isNeg ? -1 * integer : integer;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
// beats: 89% TC: O(t.len)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == tLen) {
            if (sLen == 0)
                return true;
            else if (s.equals(t))
                return true;
            else
                return false;
        }
        if (sLen > tLen)
            return false;

        int from = 0;
        for (char c : s.toCharArray()) {
            boolean found = false;
            for (; from < tLen; from++) {
                if (c == t.charAt(from)) {
                    found = true;
                    from++;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }
}
// @lc code=end

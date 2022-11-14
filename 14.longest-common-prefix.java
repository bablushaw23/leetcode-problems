import java.util.Arrays;

/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {

    // TC: O(mn) m=length of smallest string. 12% faster
    // public String longestCommonPrefix(String[] strs) {
    // String prefix = "";
    // int[] lengths = new int[strs.length];
    // for (int i = 0; i < strs.length; i++)
    // lengths[i] = strs[i].length();
    // for (int i = 0;; i++) {
    // char p;
    // int index = 1;
    // if (lengths[0] > i)
    // p = strs[0].charAt(i);
    // else
    // break;
    // for (index = 1; index < strs.length; index++) {
    // if (lengths[index] <= i || strs[index].charAt(i) != p)
    // break;
    // }
    // if (index == strs.length)
    // prefix += p;
    // else
    // break;
    // }
    // return prefix;
    // }

    // TC O(nlogn). 82% faster
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs); // Main magic here.
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }
}
// @lc code=end

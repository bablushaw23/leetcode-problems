import java.util.*;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    // Your runtime beats 60.57 % of java submissions
    // Your memory usage beats 38.14 % of java submissions (45.4 MB)
    // TC: O(n) Space: O(n)
    public int lengthOfLongestSubstring(String s) {
        int from = 1, len = 0;
        Map<Character, Integer> hs = new HashMap<>();
        int i = 1, curr_len = 0;
        int size = s.length();
        char[] chars = s.toCharArray();
        for (; i <= size; i++) {
            if (hs.containsKey(chars[i - 1]) && hs.get(chars[i - 1]) >= from) {
                curr_len = i - from;
                from = hs.get(chars[i - 1]) + 1;
                if (curr_len > len)
                    len = curr_len;
            }
            hs.put(chars[i - 1], i);
        }
        curr_len = i - from;
        if (curr_len > len)
            len = curr_len;
        return len;
    }

    // Same time as above but another logic
    // public int lengthOfLongestSubstring(String s) {
    // int i = 0, j = 0, max = 0;
    // Set<Character> set = new HashSet<>();

    // while (j < s.length()) {
    // if (!set.contains(s.charAt(j))) {
    // set.add(s.charAt(j++));
    // max = Math.max(max, set.size());
    // } else {
    // set.remove(s.charAt(i++));
    // }
    // }

    // return max;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
// @lc code=end

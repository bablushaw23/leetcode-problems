import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {

    // approach 1: copied from
    // https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
    // Anagram soln: str->char_array-> sort it and use as key
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        HashMap<String, List<String>> result = new HashMap<>();

        for (String each : strs) {
            char[] ca = each.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (result.containsKey(key))
                result.get(key).add(each);
            else {
                ArrayList<String> a = new ArrayList<>();
                a.add(each);
                result.put(key, a);
            }
        }
        return new ArrayList<>(result.values());
    }

    // A slight change, in approach, instead of sort we can use count of chars
    // beats: 58%
    // public List<List<String>> groupAnagrams(String[] strs) {
    // if (strs == null || strs.length == 0) {
    // return Collections.emptyList();
    // }
    // HashMap<String, List<String>> sameAsciiSum = new HashMap<>();

    // for (String each : strs) {
    // char[] ca = new char[26];
    // for (Character c : each.toCharArray()) {
    // ca[c - 'a']++;
    // }
    // String key = String.valueOf(ca);
    // if (sameAsciiSum.containsKey(key))
    // sameAsciiSum.get(key).add(each);
    // else {
    // ArrayList<String> a = new ArrayList<>();
    // a.add(each);
    // sameAsciiSum.put(key, a);
    // }
    // }
    // return new ArrayList<>(sameAsciiSum.values());
    // }
}
// @lc code=end

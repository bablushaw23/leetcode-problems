/*
 * @lc app=leetcode id=1324 lang=java
 *
 * [1324] Print Words Vertically
 */

import java.util.*;
import java.util.stream.Collectors;;

// @lc code=start
class Solution {
    public List<String> printVertically(String s) {
        List<StringBuilder> verticals = new ArrayList<>();
        String[] words = s.split(" ");
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            int index = 0;
            for (char each : word.toCharArray()) {
                if (verticals.size() <= index) {
                    verticals.add(new StringBuilder());
                }
                StringBuilder builder = verticals.get(index);
                while (builder.length() < wordIndex)
                    builder.append(" ");
                builder.append(each);
                index++;
            }
        }
        // stream beats 53%- 80%
        // return
        // verticals.stream().map(StringBuilder::toString).collect(Collectors.toList());
        // loop beats 96%-82%
        List<String> result = new ArrayList<>();
        for (StringBuilder each : verticals)
            result.add(each.toString());
        return result;
    }
}
// @lc code=end

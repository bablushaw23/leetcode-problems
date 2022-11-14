import java.util.Arrays;

/*
 * @lc app=leetcode id=1051 lang=java
 *
 * [1051] Height Checker
 */

// @lc code=start
class Solution {
    // beats 64% TC: O(nlogn)
    public int heightChecker(int[] heights) {
        int[] initialArrangement = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != initialArrangement[i])
                count++;
        }
        return count;
    }
}
// @lc code=end

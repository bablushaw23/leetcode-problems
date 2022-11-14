import javax.swing.text.MaskFormatter;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {

    // TC: O(n) , faster than 75%
    // saw the logic from top voted
    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;
        if (height.length == 1)
            return height[0];
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        int area;
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
// @lc code=end

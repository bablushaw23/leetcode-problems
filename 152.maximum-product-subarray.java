import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currentMax = 1;
                for (int k = i; k <= j; k++) {
                    currentMax *= nums[k];
                    max = currentMax > max ? currentMax : max;
                }
            }
        }
        return max;
    }
}
// @lc code=end

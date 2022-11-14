import java.util.Arrays;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
// beats 100%
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };
        int loc = Arrays.binarySearch(nums, target);
        if (loc < 0)
            return new int[] { -1, -1 };
        int left = loc, right = loc;
        while (loc > 0 && nums[loc - 1] == target) {
            left = Arrays.binarySearch(nums, 0, loc, target); // end-index is exclusive
            if (left >= 0)
                loc = left;
        }
        loc = right;
        while (loc < nums.length - 1 && nums[loc + 1] == target) {
            right = Arrays.binarySearch(nums, loc + 1, nums.length, target);
            if (right >= 0)
                loc = right;
        }
        return new int[] { left, right };
    }
}
// @lc code=end

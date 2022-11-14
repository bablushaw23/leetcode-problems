/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // search pivot and then pass to binary search method

        int l = 0, r = nums.length - 1;
        if (r == 0)
            if (nums[r] == target)
                return 0;
            else
                return -1;

        if (nums[r] > nums[0]) { // if array is not rotated
            return binarySearch(nums, target, 0, r);
        }

        int m = l + (r - l) / 2;
        while (l <= r) {
            if (nums[m] > nums[m + 1])
                break;
            if (nums[0] > nums[m]) // m at right of pivot
                r = m - 1;
            else // m at left of pivot
                l = m + 1;
            m = l + (r - l) / 2;
        }
        int leftIndex = binarySearch(nums, target, 0, m);
        int rightIndex = binarySearch(nums, target, m + 1, nums.length - 1);
        return Math.max(leftIndex, rightIndex);
    }

    int binarySearch(int[] nums, int target, int l, int r) {
        int m = l + (r - l) / 2;

        while (l <= r) {
            if (nums[m] == target)
                return m;
            else if (nums[m] > target)
                r = m - 1;
            else
                l = m + 1;
            m = l + (r - l) / 2;
        }
        return -1;
    }
}
// @lc code=end

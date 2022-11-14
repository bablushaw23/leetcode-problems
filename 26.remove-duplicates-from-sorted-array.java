/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start

// beats: 92% TC: O(n)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int current = nums[0], from = 1;
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                nums[from++] = nums[i];
                current = nums[i];
            }
        }
        return from--;
    }
}
// @lc code=end

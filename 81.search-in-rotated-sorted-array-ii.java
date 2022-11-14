import java.util.Arrays;

/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution81 {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == nums.length - 1) {
            return Arrays.binarySearch(nums, 0, nums.length, target) >= 0 ? true : false;
        }
        int binarySearch = Arrays.binarySearch(nums, 0, pivot, target);
        if (binarySearch >= 0) {
            return true;
        } else
            return Arrays.binarySearch(nums, pivot, nums.length, target) >= 0;
    }

    public int findPivot(int[] nums, int left, int right) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums[left + 1] < nums[left])
            return left + 1;
        int steps = 1, prevStep;
        ;
        while (left < right) {
            prevStep = left;
            if (left + steps < right) {
                left += steps;
                steps *= 2;
            } else
                left++;

            if (nums[prevStep] > nums[left]) {
                return findPivot(nums, prevStep, left);
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution81 s = new Solution81();
        // int[] nums = new int[] { 1, 2, 3, 4, 5 };
        // int[] nums = new int[] { 2, 5, 6, 0, 0, 2 };
        // int[] nums = new int[] { 9, 1, 2, 3, 4, 5 };
        // int[] nums = new int[] { 0 };
        // int[] nums = new int[] { 2, 2, 2, 3, 2, 2, 2 };
        int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
        int p = s.findPivot(nums, 0, nums.length - 1);
        System.out.println("pivot:" + p);
        boolean found = s.search(nums, 2);
        System.out.println("Found: " + found);
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
import java.util.*;

class Solution1 {
    // This soln takes nlogn+n time and 50% faster and 75% efficient

    // public int[] twoSum(int[] nums, int target) {
    // Map<Integer, List<Integer>> indexMap = new HashMap<>();
    // for (int i = 0; i < nums.length; i++) {
    // if (indexMap.containsKey(nums[i])) {
    // indexMap.get(nums[i]).add(i);
    // } else {
    // List<Integer> list = new ArrayList<>(1);
    // list.add(i);
    // indexMap.put(nums[i], list);
    // }
    // }
    // Arrays.sort(nums);

    // for (int indexA = 0; indexA < nums.length; indexA++) {
    // int indexB = Arrays.binarySearch(nums, target - nums[indexA]);
    // if (indexB >= 0 && indexA != indexB) {
    // if (nums[indexA] == nums[indexB]) {
    // return new int[] { indexMap.get(nums[indexA]).get(0),
    // indexMap.get(nums[indexA]).get(1) };
    // } else {
    // return new int[] { indexMap.get(nums[indexA]).get(0),
    // indexMap.get(nums[indexB]).get(0) };
    // }
    // }

    // }
    // return new int[] { -1, -1 };
    // }

    // this soln result:
    // Your runtime beats 89.55 % of java submissions
    // Your memory usage beats 92.61 % of java submissions (42.3 MB)
    // ********************************** OPTIMIZED*************************
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }

    // public static void main(String[] args) {
    // Solution s = new Solution();
    // System.out.println(Arrays.toString(s.twoSum(new int[] { 3, 2, 4 }, 6)));
    // }
}
// @lc code=end

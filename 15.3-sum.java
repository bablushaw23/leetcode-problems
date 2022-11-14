import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {

    // public static void main(String[] args) {
    // Solution15 s = new Solution15();
    // s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
    // }
    /*
     * approach 0: 3 for loops... TLE for 315/318
     * app:1: optimize app:0, add hashSet for index, remove for loop of k, TLE at
     * 316/318..
     * it has all zeroes in array, soln: get distinct elements. TLE 317/318 for TC
     * having lots of 0,1,-1
     * 
     */
    // public List<List<Integer>> threeSum(int[] nums) {

    // List<List<Integer>> result = new ArrayList<List<Integer>>();
    // Set<List<Integer>> set = new HashSet<List<Integer>>();

    // HashMap<Integer, Set<Integer>> track = new HashMap<>();
    // Set<Integer> distinctElems = new HashSet<>();

    // for (int index = 0; index < nums.length; index++) {
    // if (track.get(nums[index]) == null) {
    // distinctElems.add(nums[index]);
    // track.put(nums[index], new HashSet<>());
    // }
    // track.get(nums[index]).add(index);
    // }

    // if (distinctElems.size() == 1) {
    // // only possible if more than 2 0's are available
    // if (track.get(0) != null && track.get(0).size() > 2)
    // result.add(Arrays.asList(new Integer[] { 0, 0, 0 }));
    // return result;
    // }

    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if (track.get(-1 * nums[i] - nums[j]) == null)
    // continue;
    // for (int k : track.get(-1 * nums[i] - nums[j])) {
    // if (k == i || k == j)
    // continue;
    // if (nums[i] + nums[j] + nums[k] == 0) {
    // Integer[] list = new Integer[3];
    // if (nums[i] <= nums[j] && nums[i] <= nums[k]) {
    // list[0] = nums[i];
    // if (nums[j] <= nums[k]) {
    // list[1] = nums[j];
    // list[2] = nums[k];
    // } else {
    // list[1] = nums[k];
    // list[2] = nums[j];
    // }
    // } else if (nums[j] <= nums[k] && nums[j] <= nums[i]) {
    // list[0] = nums[j];
    // if (nums[i] <= nums[k]) {
    // list[1] = nums[i];
    // list[2] = nums[k];
    // } else {
    // list[1] = nums[k];
    // list[2] = nums[i];
    // }
    // } else {
    // list[0] = nums[k];
    // if (nums[j] <= nums[i]) {
    // list[1] = nums[j];
    // list[2] = nums[i];
    // } else {
    // list[1] = nums[i];
    // list[2] = nums[j];
    // }
    // }
    // if (!set.contains(Arrays.asList(list))) {
    // result.add(Arrays.asList(list));
    // }
    // set.add(Arrays.asList(list));
    // }
    // }
    // }
    // }
    // return result;
    // }

    // from discussion solution:
    // https://leetcode.com/problems/3sum/discuss/143636/Java-with-set
    // beats: 10%
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2)
            return Collections.emptyList();

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList<>(result);
    }

}
// @lc code=end

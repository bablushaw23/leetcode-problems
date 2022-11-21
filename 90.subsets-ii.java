import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.InputMap;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    // variation of subsequence
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        subsetsWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // beats: 13%
    // public void subsetsWithDup(int[] nums, int ind, List<Integer> set,
    // Set<List<Integer>> result, int setInd) {
    // if (ind == nums.length) {
    // result.add(new ArrayList<>(set));
    // return;
    // }
    // set.add(nums[ind]); // pick
    // setInd++;
    // subsetsWithDup(nums, ind + 1, set, result, setInd);
    // set.remove(setInd); // not-pick
    // setInd--;
    // subsetsWithDup(nums, ind + 1, set, result, setInd);
    // }

    // beats: 57%
    // public void subsetsWithDup(int[] nums, int ind, List<Integer> set,
    // List<List<Integer>> result, int setInd) {
    // result.add(new ArrayList<>(set));
    // for (int i = ind; i < nums.length; i++) {
    // if (i > ind && nums[i] == nums[i - 1])
    // continue;
    // set.add(nums[i]); // pick
    // setInd++;
    // subsetsWithDup(nums, i + 1, set, result, setInd);
    // set.remove(setInd); // not-pick
    // setInd--;
    // }
    // }

    // beats: 86.53%
    public static void subsetsWithDup(int[] nums, int ind, List<Integer> resultPart, List<List<Integer>> result) {
        if (ind >= nums.length)
            return;

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            else {
                resultPart.add(nums[i]);
                result.add(new ArrayList<>(resultPart));
                subsetsWithDup(nums, i + 1, resultPart, result);
                resultPart.remove(resultPart.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        subsetsWithDup(new int[] { 1, 2, 3 }, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
}
// @lc code=end

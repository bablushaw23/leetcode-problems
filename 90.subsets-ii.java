import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        subsetsWithDup(nums, 0, new ArrayList<>(), result, -1);
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

    // beats: 50%
    public void subsetsWithDup(int[] nums, int ind, List<Integer> set, List<List<Integer>> result, int setInd) {
        result.add(new ArrayList<>(set));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            System.out.println("Add:" + nums[i]);
            set.add(nums[i]); // pick
            setInd++;
            subsetsWithDup(nums, i + 1, set, result, setInd);
            System.out.println("remove:" + set.get(setInd));
            set.remove(setInd); // not-pick
            setInd--;
        }
    }
}
// @lc code=end

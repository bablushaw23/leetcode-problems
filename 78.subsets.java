import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    // problem is variation of subsequence
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), resultList);
        return resultList;
    }

    public void subsets(int[] nums, int ind, List<Integer> set, List<List<Integer>> result) {
        if (ind == nums.length) {
            result.add(new ArrayList<>(set)); // n-sized op
            return;
        }
        set.add(nums[ind]); // pick
        subsets(nums, ind + 1, set, result);
        set.remove(set.size() - 1); // not-pick
        subsets(nums, ind + 1, set, result);
    }
}
// @lc code=end

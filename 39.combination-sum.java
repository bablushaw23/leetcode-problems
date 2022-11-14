import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    public static void combinationSum(int ind, int sum, int[] candidates, List<Integer> combination,
            List<List<Integer>> result) {
        if (sum == 0) { // save result when sum is 0
            List<Integer> subRes = new ArrayList<>();
            for (int elem : combination)
                subRes.add(elem);
            result.add(subRes);
            return;
        }
        if (ind == candidates.length || sum < 0) { // base case
            return;
        }
        combination.add(candidates[ind]); // select an element
        // go next to select same element, no change in ind but sum is reduced
        combinationSum(ind, sum - candidates[ind], candidates, combination, result);
        // work or not, remove the selected
        combination.remove(combination.size() - 1);
        // go next for different elem, index changed but sum not as current selection is
        // rejected
        combinationSum(ind + 1, sum, candidates, combination, result);
    }

}
// @lc code=end

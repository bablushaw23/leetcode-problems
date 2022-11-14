import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        uniqueSets(0, target, candidates, new ArrayList(), result);
        return result;
    }

    // beats: 85%
    public void uniqueSets(int ind, int sum, int[] cand, List<Integer> combination, List<List<Integer>> result) {
        // base condition
        if (sum == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (sum < 0 || ind >= cand.length)
            return;

        if (cand[ind] <= sum) {
            combination.add(cand[ind]);
            uniqueSets(ind + 1, sum - cand[ind], cand, combination, result);
            combination.remove(combination.size() - 1);
        }
        // I'm skipping the next recursions where same value will be selected, so I dont
        // need hashset of log(n) to filter same value.
        // you can remove the for part and replace i with ind+1 in uniqueSet() call
        // below but it will bring duplications in result and
        // to remove duplications if u think to use HashSet and then convert to List
        // than that approach will result TLE as Set takes log(n)
        // Explaination at: https://youtu.be/G1fRTGRxXU8?t=740
        int i = ind + 1;
        for (; i < cand.length; i++) {
            if (cand[i] != cand[ind])
                break;
        }
        uniqueSets(i, sum, cand, combination, result);
    }
}
// @lc code=end

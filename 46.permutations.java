import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

//Runtime 2ms mem: 45mb, with aux spaced array for check

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         permute(nums, new boolean[nums.length], result, new ArrayList<>());
//         return result;
//     }

//     public void permute(int[] nums, boolean[] checked, List<List<Integer>> result, List<Integer> set) {
//         // save when set has all elems, i.e., a permutation
//         if (set.size() == nums.length) {
//             result.add(new ArrayList<>(set));
//             return;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (checked[i])
//                 continue;
//             checked[i] = true;
//             set.add(nums[i]);
//             permute(nums, checked, result, set);
//             checked[i] = false; // re-seting is necessary to come back to initial state.
//             set.remove(set.size() - 1);
//         }
//     }
// }

class Solution {

    // beats 5.21% when used arrays.stream and mem: 44.6MB when result was not
    // global
    public List<List<Integer>> permute(int[] nums) {

        // permute(nums, 0);
        // return result;

        boolean[] marked = new boolean[nums.length];
        // List<Integer> result = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        // permute(nums, marked, result, results);
        permute(0, nums, results);
        return results;

    }

    // making this local, makes code space: 42MB to 45.1 MB
    List<List<Integer>> result = new ArrayList<>();

    // void permute(int[] nums, int ind) {
    // if (ind >= nums.length) {
    // // commenting this made code faster from 5% to 100% and memory 42MB
    // // result.add(Arrays.stream(nums).boxed().collect(Collectors.toList())); //
    // TC:
    // // n
    // List<Integer> subList = new ArrayList<>();
    // for (int e : nums) {
    // subList.add(e);
    // }
    // result.add(subList);
    // return;
    // }
    // for (int i = ind; i < nums.length; i++) {
    // int swap = nums[ind];
    // nums[ind] = nums[i];
    // nums[i] = swap;
    // permute(nums, ind + 1);
    // swap = nums[i];
    // nums[i] = nums[ind];
    // nums[ind] = swap;
    // }
    // }

    // attemt at: 19-11-22- using marked array
    // beats 81% TC: n!*n, n for saving into results
    // void permute(int[] nums, boolean[] marked, List<Integer> result,
    // List<List<Integer>> results) {
    // if (result.size() == nums.length) {
    // results.add(new ArrayList<>(result));
    // return;
    // }
    // for (int i = 0; i < nums.length; i++) {
    // if (!marked[i]) {
    // result.add(nums[i]);
    // marked[i] = true;
    // permute(nums, marked, result, results);
    // marked[i] = false;
    // result.remove(result.size() - 1);
    // }
    // }
    // }

    // attempt: 19-11-22 using swap, beats 6%, as it redundently swaps and calls
    void permute(int ptr, int[] nums, List<List<Integer>> results) {
        if (ptr >= nums.length)
            return;
        for (int i = ptr; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] = nums[ptr];
            nums[ptr] = tmp;
            if (i != ptr)
                results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            permute(ptr + 1, nums, results);
            nums[ptr] = nums[i];
            nums[i] = tmp;
        }
    }

}

// @lc code=end

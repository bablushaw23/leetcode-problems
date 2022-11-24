import java.util.Arrays;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // return climbStairs(0, n); // for simple recursion
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        // return climbStairs(0, n, memo);
        return climbStairsSpaceOpt(n);
    }

    // simple-recursion bottom up
    // TLE- ofcourse
    public int climbStairs(int now, int last) {
        if (now == last)
            return 1;
        if (now > last)
            return 0;
        return climbStairs(now + 1, last) + climbStairs(now + 2, last);
    }

    // beats 100% - using memoization- Top down
    // Time: O(n) as each step is only computed once
    // Explain why O(n), or how each step is only computed once?
    // say climbStairs for n=15, you have to cover step no.7(randomly taken) for
    // that
    // now u either take it from 5+2 or 6+1, but at 1st encounter,(suppose 5+2) u
    // record memo[7], so for 2nd encounter u just call memo[7] in O(1) and use it
    // this way I say I am computing only once for each step.
    // space- beats: 69%
    // complexity: O(n) for stack in recursion(tree height) and O(n) for memo
    public int climbStairs(int now, int last, int[] memo) {
        if (now == last)
            return 1;
        if (now > last)
            return 0;
        if (memo[now + 1] == -1) { // if not already computed
            memo[now + 1] = climbStairs(now + 1, last, memo); // then compute and save
        }
        if (memo[now + 2] == -1) { // same
            memo[now + 2] = climbStairs(now + 2, last, memo);
        }
        // by this line, I ensure I have answers in memo, so using it
        memo[now] = memo[now + 1] + memo[now + 2];
        return memo[now];
    }

    // trying for space: O(n)... bottom-up
    // in space, beats: 86%
    public int climbStairsSpaceOpt(int n) {
        int curr = 0, prev1 = 1, prev2 = 2;
        if (n == 1) // when only 1 stair
            return 1;
        if (n == 2) // when only 2 stairs
            return 2;
        for (int i = n - 3; i >= 0; i--) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }

}
// @lc code=end

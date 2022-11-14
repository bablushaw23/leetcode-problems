/*
 * @lc app=leetcode id=1299 lang=java
 *
 * [1299] Replace Elements with Greatest Element on Right Side
 */

// @lc code=start
class Solution {
    // beats 100% TC: O(n)
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length]; // to store result
        result[arr.length - 1] = -1; // edge case

        // starting from last (2nd last i mean)
        int max = arr[arr.length - 1]; // consider max value

        // from last to 1st element, keep track of largest element and replace until
        // more larger is found
        for (int i = arr.length - 2; i >= 0; i--) {
            result[i] = max;
            if (arr[i] > max)
                max = arr[i];
        }
        return result;
    }
}
// @lc code=end

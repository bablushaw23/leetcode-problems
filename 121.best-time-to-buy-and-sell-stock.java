/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        for (int i = 0; i < prices.length - 1; i++) {
            int max = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max)
                    max = profit;
            }
            prices[i] = max;
        }
        prices[prices.length - 1] = 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > max)
                max = prices[i];
        }
        return max;
    }
}
// @lc code=end

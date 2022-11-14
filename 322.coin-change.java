import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        int coinCount = 0;
        int count = 0, coin = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            coin = coins[i];
            count = amount / coin;

            amount = (count > 0) ? (amount % coin) : amount;
            coinCount += count;
        }
        if (coinCount == 0 || amount != 0)
            return -1;
        return coinCount;
    }
}
// @lc code=end

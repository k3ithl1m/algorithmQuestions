/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (28.54%)
 * Total Accepted:    153.5K
 * Total Submissions: 537.6K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 *
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
class Solution {
    public int coinChange2(int[] coins, int amount) {
	if (coins.length == 0) return -1;
	int val = recurseCoinCount(coins, amount,new int[amount+1]);
	return (val == Integer.MAX_VALUE) ? -1 : val;
    }

    public int coinChange(int[] coins, int amount) {
	if (coins.length == 0) return -1;
	int[] dp = new int[amount + 1];
	Arrays.fill(dp, amount+1);
	for (int i = 1; i <= amount; i++) {
		for (int coin : coins) {
			if (coin <= i) {
				dp[i] = Math.min(dp[i], dp[i-coin] + 1);
			}
		}
	}
	return dp[amount] > amount ? -1 : dp[amount];
    }

    private int coinChange(int[] coins, int rem, int[] count) {
	if (rem < 0) return -1;
	if (rem == 0) return 0;
	if (count[rem - 1] != 0) return count[rem-1];
	int min = Integer.MAX_VALUE;
	for (int coin: coins) {
		int res = coinChange(coins, rem - coin, count);
		if (res >= 0 && res < min) min = 1 + res;
	}
	count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
	return count[rem - 1];
    }

    public int recurseCoinCount(int[] coins, int amount, int[] coinCache) {
	if (amount < 0) return Integer.MAX_VALUE;
	if (amount == 0) return 0;
	if (coinCache[amount] != 0) return coinCache[amount];
	int currentMin = Integer.MAX_VALUE;
	for (int coin: coins) {
		if (amount - coin >= 0) {
			int nowMin = recurseCoinCount(coins, amount- coin, coinCache);
			if (nowMin >= 0 && nowMin < currentMin) currentMin = nowMin + 1;
		}
	}
	coinCache[amount] = currentMin;
	return coinCache[amount];
    }

}

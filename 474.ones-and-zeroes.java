/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (39.06%)
 * Total Accepted:    27.8K
 * Total Submissions: 71.2K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * In the computer world, use restricted resource you have to generate maximum
 * benefit is what we always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the
 * other hand, there is an array with strings consisting of only 0s and 1s.
 * 
 * 
 * Now your task is to find the maximum number of strings that you can form
 * with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * 
 * 
 * Note:
 * 
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * 
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are “10,”0001”,”1”,”0”
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * 
 * Explanation: You could form "10", but then you'd have nothing left. Better
 * form "0" and "1".
 * 
 * 
 */

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
	if (strs.length == 0) return 0;
	if (m == 0 && n == 0) return 0;
	NumZeroesOnes[] zeroesOnesArray = new NumZeroesOnes[strs.length];
	for (int i = 0; i < strs.length; i++) {
		String str = strs[i];
		int zeroes = 0, ones = 0;
		for (char c : str.toCharArray()) {
			if (c=='0') zeroes++;
			else ones++;
		}
		zeroesOnesArray[i] = new NumZeroesOnes(zeroes, ones);
	}

	int[] countCache = new int[strs.length];
	NumZeroesOnes[] remainder = new NumZeroesOnes[strs.length];
	int maxCount = 0;
	Arrays.fill(countCache, -1);
	for (int i = 0; i < strs.length; i++) {
		maxCount = Math.max(maxCount, recurseCount(zeroesOnesArray, m, n, i, countCache, remainder));
	}

	return maxCount;
    }

    private int recurseCount(NumZeroesOnes[] zeroesOnesArray, int m, int n, int pos, int[] countCache,
		NumZeroesOnes[] remainder) {
	if (pos >= zeroesOnesArray.length || (m <= 0 && n <= 0)) return 0;
	if (countCache[pos] > -1) {
		if ( m >= remainder[pos].zeroes && n >=remainder[pos].ones) return countCache[pos];
	}
	int maxCount = 0;
	int newM = m - zeroesOnesArray[pos].zeroes, newN = n - zeroesOnesArray[pos].ones;
	if (newM >= 0 && newN >= 0) {
		maxCount = Math.max(recurseCount(zeroesOnesArray, m, n, pos + 1, countCache, remainder),
				recurseCount(zeroesOnesArray, newM, newN, pos+1, countCache, remainder) + 1);
	} else maxCount = recurseCount(zeroesOnesArray, m, n, pos + 1, countCache, remainder);
	if (!(countCache[pos] > maxCount)) {
		countCache[pos] = maxCount;
		remainder[pos] = new NumZeroesOnes(m,n);
	}
	return maxCount;
    }
}

class NumZeroesOnes {
	int ones;
	int zeroes;
	public NumZeroesOnes(int m, int n) {
		zeroes = m;
		ones = n;
	}
}

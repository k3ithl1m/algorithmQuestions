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
	//edge cases
	int[][][] cache = new int[strs.length+1][m+1][n+1];
	int max = 0;
	for (int i = 1; i < strs.length+1; i++) {
		int ones = 0;
		int zeroes = 0;
		for (int j = 0; j < strs[i-1].length(); j++) {
			if (strs[i-1].charAt(j) == '0') zeroes++;
			else ones++;
		}
		for (int j = 0; j < cache[0].length; j++) {
			for (int k = 0; k < cache[0][0].length; k++) {
				if (j - zeroes >= 0 && k- ones >= 0) {
					cache[i][j][k] = Math.max(cache[i-1][j-zeroes][k-ones]+1, cache[i-1][j][k]);
					max = Math.max(cache[i][j][k], max);
				} else cache[i][j][k] = cache[i-1][j][k];
			}
		}
	}

	return max;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
	//edge cases
	int[][][] zeroesOnesCache = new int[strs.length+1][m+1][n+1];

	int result = 0;
	for (int i = 1; i < strs.length+1; i++) {
		String currentStr = strs[i-1];
		int ones = 0;
		int zeroes = 0;
		for (int j = 0; j < currentStr.length(); j++) {
			if (currentStr.charAt(j) == '0') zeroes++;
			else ones++;
		}

		for (int j = 0; j < zeroesOnesCache[0].length; j++) {
			for (int k = 0; k < zeroesOnesCache[0][0].length; k++) {
				if (j - zeroes >= 0 && k - ones >= 0) {
					zeroesOnesCache[i][j][k] = Math.max(
						zeroesOnesCache[i-1][j-zeroes][k-ones] + 1,
						zeroesOnesCache[i-1][j][k]);
					result = Math.max(result, zeroesOnesCache[i][j][k]);
				} else zeroesOnesCache[i][j][k] = zeroesOnesCache[i-1][j][k];
			}
		}
		
	}

	return result;
    }
}


/*
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (39.37%)
 * Total Accepted:    145K
 * Total Submissions: 368K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class Solution {
    public int numSquares(int n) {
    	if (Math.sqrt(n) % 1 == 0) return 1;  
	else {
		int[] memo = new int[n + 1];
		memo[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (Math.sqrt(i) % 1 == 0) memo[i] = 1;
			else {
				int min = Integer.MAX_VALUE;
				int j = 1;
				while(i - j*j >= 0) {
					min = Math.min(min, memo[i-j*j] + 1);
					++j;
				}
				memo[i] = min;
			}
		}
		return memo[n];
	}
    }
}

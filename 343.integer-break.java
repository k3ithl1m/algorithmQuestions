/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (47.21%)
 * Total Accepted:    72K
 * Total Submissions: 152.7K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */
class Solution {
    public int integerBreak(int n) {
	if (n==0) return 0;
	if (n==1) return 1;
	int[] maxPerNumArray = new int[n+1];
	Arrays.fill(maxPerNumArray, -1);
	maxPerNumArray[0] = 1;
	maxPerNumArray[1] = 1;
	return recurseCalculate(n, maxPerNumArray);        
    }

    public int recurseCalculate(int n, int[] maxPerNumArray) {
	if (maxPerNumArray[n] != -1) return maxPerNumArray[n];
	int max = 0;
	for (int i = 1; i < n; i++) {
		int remainder = n - i;
		int total = i * Math.max(remainder, recurseCalculate(remainder, maxPerNumArray));
		System.out.println(n + " " + total);
		max = Math.max(total, max);
	}

	maxPerNumArray[n] = max;
	return maxPerNumArray[n];
    }
}

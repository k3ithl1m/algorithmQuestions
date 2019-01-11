/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (30.87%)
 * Total Accepted:    36K
 * Total Submissions: 116.7K
 * Testcase Example:  '8'
 *
 * 
 * Given a positive integer n and you can do operations as follow:
 * 
 * 
 * 
 * 
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * 
 * 
 * 
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 8
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 7
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 */
class Solution {
    public int integerReplacement(int n) {
	int finalResult = n;
	int steps = 0;
	while(finalResult!=1) {
		if (finalResult %2 == 1) 
	}	
       	return helper(n, 0); 
    }
    
    public int helper(int x, int steps) {
	if (x == 1) return steps;
	if (x % 2 == 1) return Math.min(helper(x+1, steps+1), helper(x-1, steps+1));
	else return helper(x/2, steps+1);
    }
}

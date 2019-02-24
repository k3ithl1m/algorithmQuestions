/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (32.79%)
 * Total Accepted:    38.7K
 * Total Submissions: 118K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * Example 1:
 * 
 * 
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: False
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean judgeSquareSum(int c) {
	for (long a = 0; a * a <= c; a++) {
		double b = Math.sqrt(c - (a*a));
		if (b == (int) b) return true;
	}        
	return false;
    }
}

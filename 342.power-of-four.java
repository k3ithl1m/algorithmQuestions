/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (39.81%)
 * Total Accepted:    102.3K
 * Total Submissions: 256.9K
 * Testcase Example:  '16'
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example 1:
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: false
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
class Solution {
    public boolean isPowerOfFour(int num) {
	Arrays.sort(num);
	int mid = num.length/2 + 1;
	for (int i = 2; i + mid < num.length; i+=2) {
		int temp = num[i];
		num[i] = num[i+mid];
		num[i+mid] = temp;
	}
        
    }
}

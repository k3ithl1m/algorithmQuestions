/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * algorithms
 * Medium (50.05%)
 * Total Accepted:    32.9K
 * Total Submissions: 65.7K
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai <
 * 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * 
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [3, 10, 5, 25, 2, 8]
 * 
 * Output: 28
 * 
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * 
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
	int max = 0;
	for (int i = 0; i < nums.length-1; i++) {
		for (int j = i; j < nums.length; j++) {
			max = Math.max(nums[i] ^ nums[j], max);
		}
	}

	return max;
    }
}

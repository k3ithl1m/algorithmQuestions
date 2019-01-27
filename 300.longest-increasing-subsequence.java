/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (39.96%)
 * Total Accepted:    186.4K
 * Total Submissions: 466.1K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
	if (nums.length == 0) return 0;
	int[] count = new int[nums.length];
	Arrays.fill(count, 1);
	int max = 0;
	for (int i = 0; i < nums.length; i++) {
		for (int j = 0; j < i; j++) {
			if (nums[i] >nums[j] && count[i] <= count[j]) {
				count[i] = count[j]+1;
			}
		}
		if (count[i] > max) max = count[i];
		System.out.println(count[i]);
	}        
	
	return max;
    }
}

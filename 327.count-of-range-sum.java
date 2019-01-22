/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 *
 * https://leetcode.com/problems/count-of-range-sum/description/
 *
 * algorithms
 * Hard (31.66%)
 * Total Accepted:    28.6K
 * Total Submissions: 90.1K
 * Testcase Example:  '[-2,5,-1]\n-2\n2'
 *
 * Given an integer array nums, return the number of range sums that lie in
 * [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between
 * indices i and j (i ≤ j), inclusive.
 * 
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * 
 * Example:
 * 
 * 
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3 
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective
 * sums are: -2, -1, 2.
 * 
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
	if (nums.length == 0) return 0;
	int total = 0;
	long sum = 0;
	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
		if (sum >= lower && sum <= upper) total++;
		for (int j = i+1; j < nums.length; j++) {
			sum += nums[j];
			if (sum >= lower && sum <= upper) total++;
		}
		sum = 0;
	}        
	return total;
    }
}

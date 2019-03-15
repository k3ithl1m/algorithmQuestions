/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (39.04%)
 * Total Accepted:    47K
 * Total Submissions: 120.1K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output
 * the maximum average value.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * 
 * 
 * 
 * 
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) return 0;
	if (nums.length == 0) return 0;
	double total = 0;
	double maxAverage = -Double.MAX_VALUE;
	int count = 0;
	for (int i = 0; i < nums.length; i++) {
		total += nums[i];
		count++;
		if (count > k) {
			total -= nums[i - k];
			count--;
		}
		if (count == k) {
			maxAverage = Math.max(maxAverage, (double)total / k);
		}	
	}
	return maxAverage;
    }
}

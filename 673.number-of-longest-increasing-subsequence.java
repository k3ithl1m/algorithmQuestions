/*
 * [673] Number of Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (32.69%)
 * Total Accepted:    24.4K
 * Total Submissions: 74.7K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * 
 * Given an unsorted array of integers, find the number of longest increasing
 * subsequence.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1,
 * 3, 5, 7].
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 * 
 * 
 * 
 * Note:
 * Length of the given array will be not exceed 2000 and the answer is
 * guaranteed to be fit in 32-bit signed int.
 * 
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
	int[] count = new int[nums.length];
	Arrays.fill(count, 1);
	int[] length = new int[nums.length];
	
	for (int i = 0; i < nums.length; i++) {
		for (int j = 0; j < i; j++) {
			if ( nums[i]>nums[j]) {
				if (length[j]>=length[i]) {
					length[i] = length[j] + 1;
					count[i] = count[j];
				} else if (length[j] + 1 == length[i]) {
					count[i]+=count[j];
				}
			}
		}
	}

	int maxLength = 0, maxCount = 0;
	for (int i : length) {
		if ( i > maxLength) maxLength = i;
	}

	for ( int i = 0; i < length.length; i++) {
		if ( length[i] == maxLength) maxCount += count[i];
	}
	return maxCount;
    }
}

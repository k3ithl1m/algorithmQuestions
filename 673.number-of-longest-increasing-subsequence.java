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
	if (nums.length <= 0) return 0;
	ArrayList<Integer> ar = new ArrayList<Integer>();
	int[] count = new int[nums.length];
	count[0] = 1;
	ar.add(nums[0]);
	for (int i = 1; i < count.length; i++) {
		int prev = ar.get(ar.size() - 1);
		if (nums[i] == prev) count[i] = count[i-1]+1;
		else if (nums[i] > prev) {
			count[i] = count[i-1];
			ar.add(nums[i]);
		} else {
			if (ar.size() <= 1 || nums[i] >= ar.get(ar.size() -2 ))  count[i] = count[i-1] +1;
			else count[i] = count[i-1];
		}
	}        
	return count[nums.length-1];
    }
}

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (39.66%)
 * Total Accepted:    72.4K
 * Total Submissions: 182.4K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * 
 * Note:
 * 
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 */
class Solution {
    public boolean canPartition(int[] nums) {
	int sum = 0;
	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
	}
	if (sum%2 > 0) return false;
	sum /=2;
	boolean[][] resultCache = new boolean[nums.length + 1][sum + 1];
	for (int i = 0; i < resultCache.length; i++) {
		Arrays.fill(resultCache[i], false);
	}

	resultCache[0][0] = true;
	for (int i = 1; i < resultCache.length; i++) {
		resultCache[i][0]=true;
	} 

	for(int j = 1; j < resultCache[0].length; j++) {
		resultCache[0][j] = false;
	}

	for (int i = 1; i < resultCache.length; i++) {
		for (int j = 1; j < resultCache[0].length; j++) {
			resultCache[i][j] = resultCache[i-1][j];
			if (j>=nums[i-1]) resultCache[i][j] = resultCache[i][j] || resultCache[i-1][j-nums[i-1]];
		}
	}
	return resultCache[nums.length][sum];
    }
}

/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 *
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (41.65%)
 * Total Accepted:    35.3K
 * Total Submissions: 84.7K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an
 * algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * Note:
 * If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * 
 * 
 * Examples: 
 * 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * 
 */
class Solution {
    public int splitArray(int[] nums, int m) {
	int[][] countCache = new int[m+1][nums.length+1];
	for (int i = 0; i < countCache.length; i++) {
		Arrays.fill(countCache[i], -1);
	}
	if (m == 1) {
		int total = 0;
		for (int i = 0; i < nums.length; i++) total+=nums[i];
		return total;
	}
        return findMax(nums, m, 0, countCache);
    }
   
    private int findMax(int[] nums, int m, int pos, int[][] countCache) {
	if (pos >= nums.length) return 0;
	if (m <= 0) return 0;
	int countMax = 0, countSum = 0;
	int countMin = Integer.MAX_VALUE;
	for (int i = pos; i <= nums.length - m; i++) {
		countSum += nums[i];
		countMax = Math.max(countSum, findMax(nums, m-1, i+1, countCache));
		if (pos == 0) countMin = Math.min(countMin, countMax);
	}
	return (pos==0) ? countMin : countMax;
    }
}

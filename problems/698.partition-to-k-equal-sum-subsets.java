/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 *
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * algorithms
 * Medium (40.65%)
 * Total Accepted:    33.1K
 * Total Submissions: 81.5K
 * Testcase Example:  '[4,3,2,3,5,2,1]\n4'
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 * 
 * 
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
	if (nums.length == 0) {
		if (k==0) return true;
		else return false;
	}        
	if (k > nums.length) return false;
	int maxNum = 0;
	int sum = 0;
	TreeMap<Integer, Integer> numberCountMap = new TreeMap<>();

	for (int num : nums) {
		sum += num;
		maxNum = Math.max(num, maxNum);
		numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
	}

	int bucketValue = sum / k;
	if (maxNum > bucketValue || sum % k != 0) return false;
	int bucketCount = k;
	while (!numberCountMap.isEmpty()) {
		if (bucketCount == 0) return false;
		int currentCount = bucketValue;
		while (currentCount > 0) {
			Integer getNumber = numberCountMap.floorKey(currentCount);
			if (getNumber != null) {
				currentCount -= getNumber;
				if (numberCountMap.get(getNumber) != 1) {
					numberCountMap.put(getNumber, numberCountMap.get(getNumber) -1);
				} else numberCountMap.remove(getNumber);
			} else return false;
		}
		bucketCount--;
	}

	return true;
    }
}

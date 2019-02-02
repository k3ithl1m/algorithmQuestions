/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 *
 * https://leetcode.com/problems/delete-and-earn/description/
 *
 * algorithms
 * Medium (44.69%)
 * Total Accepted:    17.8K
 * Total Submissions: 39.8K
 * Testcase Example:  '[3,4,2]'
 *
 * Given an array nums of integers, you can perform operations on the array.
 * 
 * In each operation, you pick any nums[i] and delete it to earn nums[i]
 * points. After, you must delete every element equal to nums[i] - 1 or nums[i]
 * + 1.
 * 
 * You start with 0 points. Return the maximum number of points you can earn by
 * applying such operations.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation: 
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation: 
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
	if (nums.length == 0) return 0;
	if (nums.length == 1) return nums[0];
	int maxNum = 0;
	HashMap<Integer, Integer> totalMap = new HashMap<>();
	for (int num : nums) {
		totalMap.put(num, totalMap.getOrDefault(num, 0) + 1);
		if (num > maxNum) maxNum = num;
	}        

	int[] sumsArray = new int[maxNum + 1];
	int[] sumsCache = new int[maxNum + 1];
	for (int num : totalMap.keySet()) {
		sumsArray[num] = totalMap.get(num) * num;
	}

	for (int i = 1; i < sumsArray.length; i++) {
		sumsCache[0] = Math.max(sumsCache[0], recurseCount(nums, i, sumsArray, sumsCache));
	}

	return sumsCache[0];
    }

    private int recurseCount(int[] nums, int pos, int[] sumsArray, int[] sumsCache) {
	if (sumsCache[pos] > 0) return sumsCache[pos];
	int maxCount = sumsArray[pos];
	for (int i = pos + 2; i < sumsArray.length; i++) {
		maxCount = Math.max(maxCount, recurseCount(nums, i, sumsArray, sumsCache) + sumsArray[pos]);
	}
	sumsCache[pos] = maxCount;
	return sumsCache[pos];
    }
}

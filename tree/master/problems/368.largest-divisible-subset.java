/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 *
 * https://leetcode.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (34.37%)
 * Total Accepted:    42.7K
 * Total Submissions: 124.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * 
 * 
 * 
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
	LinkedList<Integer> resultList = new LinkedList<>();
	if (nums.length == 0) return resultList;
	if (nums.length == 1) {
		resultList.add(nums[0]);
		return resultList;
	}
	Arrays.sort(nums);
	int[] count = new int[nums.length];
	int[] index = new int[nums.length];
	Arrays.fill(index, -1);
	int maxIndex = 0;
	int maxCount = 0;
	for (int i = 0; i < nums.length; i++) {
		for (int j = i-1; j >= 0; j--) {
			if (nums[i] % nums[j] == 0 && count[j] + 1 >= count[i]) {
				count[i] = count[j] + 1;
				index[i] = j;
				if (count[i] > maxCount) {
					maxCount = count[i];
					maxIndex = i;
				}
			}
		}
	}

	while (maxIndex != -1) {
		resultList.addFirst(nums[maxIndex]);
		maxIndex = index[maxIndex];
	}
	return resultList;
    }
}

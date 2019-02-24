/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (39.43%)
 * Total Accepted:    17.2K
 * Total Submissions: 43.4K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * You are given an integer array sorted in ascending order (may contain
 * duplicates), you need to split them into several subsequences, where each
 * subsequences consist of at least 3 consecutive integers. Return whether you
 * can make such a split.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [1,2,3,4,4,5]
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The length of the input is in range of [1, 10000]
 * 
 * 
 */
class Solution {
    public boolean isPossible(int[] nums) {
 	if (nums.length < 3) return false;
	TreeMap<Integer, Integer> rankMap = new TreeMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
		rankMap.put(nums[i], rankMap.getOrDefault(nums[i],0) + 1);
	}       
	while (!rankMap.isEmpty()) {
		int firstKey = rankMap.firstKey();
		int count = 2;
		int maxCount = rankMap.get(firstKey);
		if (maxCount > 1) rankMap.put(firstKey, maxCount - 1);
		else rankMap.remove(firstKey);
		while (rankMap.get(firstKey+1) != null && rankMap.get(firstKey + 1) >= maxCount) {
			count--;
			firstKey++;
			maxCount = rankMap.get(firstKey);
			if (maxCount > 1) rankMap.put(firstKey, maxCount - 1);
			else rankMap.remove(firstKey);
		}

		if (count > 0) return false;	
	}
	return true;
    }
}

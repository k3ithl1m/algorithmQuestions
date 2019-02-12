/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 *
 * https://leetcode.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (47.75%)
 * Total Accepted:    39.1K
 * Total Submissions: 81.9K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 
 * Given scores of N athletes, find their relative ranks and the people with
 * the top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * 
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two
 * athletes, you just need to output their relative ranks according to their
 * scores.
 * 
 * 
 * 
 * Note:
 * 
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 * 
 * 
 * 
 */
class Solution {
    public String[] findRelativeRanks(int[] nums) {
	if (nums.length == 0) return new String[0];
	if (nums.length == 1) return new String[]{"Gold Medal"};
	TreeMap<Integer, Integer> scorePositionMap = new TreeMap<>(Collections.reverseOrder());
	for (int i = 0; i < nums.length; i++) {
		scorePositionMap.put(nums[i], i);
	}        
	String[] awardArray = new String[nums.length];
	Map.Entry<Integer, Integer> tempEntry = scorePositionMap.pollFirstEntry();
	awardArray[tempEntry.getValue()] = "Gold Medal";
	tempEntry = scorePositionMap.pollFirstEntry();
	awardArray[tempEntry.getValue()] = "Silver Medal";
	if (nums.length > 2) {
		tempEntry = scorePositionMap.pollFirstEntry();
		awardArray[tempEntry.getValue()] = "Bronze Medal";
	} else return awardArray;
	int i = 4;
	while (!scorePositionMap.isEmpty()){
		tempEntry = scorePositionMap.pollFirstEntry();
		awardArray[tempEntry.getValue()] = String.valueOf(i);
		i++;
	}
	return awardArray;
	
    }
}

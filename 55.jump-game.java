/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.24%)
 * Total Accepted:    234.7K
 * Total Submissions: 751K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
	if (nums.length == 0 || nums.length == 1) return true;
	int numJumps = 0;
	for (int i = 0; i < nums.length; i++) {
		numJumps = Math.max(numJumps, nums[i]);
		if (numJumps == 0 && i != nums.length - 1) return false;
		numJumps--;
	}
	return true;
	//return findPossibility(nums, 0);        
    }

    private boolean findPossibility(int[] nums, int position) {
	if (position >= nums.length -1) return true;
	int jumps = nums[position];
	for (int i = 1; i <= jumps; i++) {
		if (findPossibility(nums, position + i)) return true;
	}
	return false;
    }
}

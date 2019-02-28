/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms * Medium (32.50%)
 * Total Accepted:    157.3K
 * Total Submissions: 484K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
	if (nums.length == 0) return false;
	if (nums.length == 1) return nums[0] == target;
	int left = 0, right = nums.length-1;
	while (left <= right) {
		int middle = left + (right - left) / 2;
		if (nums[middle] == target || nums[left] == target || nums[right] == target) return true;
		if (nums[left] < nums[middle]) {
			if (nums[middle] > target && nums[left] < target) {
				right = middle;
			} else left = middle;
		} else if (nums[middle] < nums[left]) {
			if (nums[middle] < target && nums[right] > target) left = middle;
			else right = middle;
		} else left++;
	}        
	return false;
    }
}

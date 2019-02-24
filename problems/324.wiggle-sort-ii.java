/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (27.10%)
 * Total Accepted:    51K
 * Total Submissions: 187.6K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
class Solution {
    public void wiggleSort(int[] nums) {
	Arrays.sort(nums);
	int mid = nums.length/2;
	for (int i = 1; i+mid < nums.length;i=i+2) {
		int temp = nums[i];
		nums[i] = nums[i+mid];
		nums[i+mid] = temp;	
	}        
    }
}

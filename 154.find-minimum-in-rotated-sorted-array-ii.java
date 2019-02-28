/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (38.93%)
 * Total Accepted:    121.1K
 * Total Submissions: 310.9K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                --right;
            }
        }
        return nums[left];
    }

    public int findMin(int[] nums) {
	if (nums.length == 0) return -1;
	if (nums.length == 1) return nums[0];
	if (nums.length == 2) return (nums[0] <= nums[1]) ? nums[0] : nums[1];
	int left = 0, right = nums.length - 1;
	while (left < right) {
		int mid = left + (right - left) / 2;
		if (mid - 1 >= 0 && nums[mid-1] > nums[mid]) return nums[mid];
		if (mid + 1 < nums.length && nums[mid+1] < nums[mid]) return nums[mid+1];
		if (mid - 1 < 0) return nums[mid];
		if (left + 1 == right && nums[left] == nums[right]) return nums[left];

		if (nums[mid] > nums[left]) {
			if (nums[mid] > nums[right]) left = mid;
			else right = mid;
		} else if (nums[mid] < nums[left]) {
			right = mid;
		} else left++;
	}        
	
	return (left > 0) ? nums[left-1] : nums[left];
    }
}

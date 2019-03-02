/*
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (42.00%)
 * Total Accepted:    243K
 * Total Submissions: 577.8K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */
class Solution {
    public int findMin(int[] nums) {
	if (nums.length == 0) return 0;
	if (nums.length == 1) return nums[0];
	if (nums.length == 2) return (nums[1] > nums[0]) ? nums[0] : nums[1];
	int left = 0, right = nums.length - 1;
	while (left < right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] > nums[right]) left = mid+1;
		else if (nums[mid] < nums[right]) right = mid;
		else --right;
	}

	return nums[left];
    }


    public int findMin3(int[] nums) {
	if (nums.length == 0) return 0;
	if (nums.length == 1) return nums[0];
	if (nums.length == 2) return (nums[1] > nums[0]) ? nums[0] : nums[1];
	int left = 0, right = nums.length - 1;
	while (left <= right) {
		int mid = left + (right-left) /2;
		if (mid - 1 >= 0 && nums[mid-1] > nums[mid]) return nums[mid];
		else if (mid - 1 < 0) return nums[mid];

		if (nums[mid] > nums[left]) {
			if (nums[mid] <= nums[right]) right = mid;
			else left = mid;
		} else if (nums[mid] < nums[left]) {
			if (nums[mid] > nums[right]) left = mid;
			right = mid;
		} else left++;
	}
	return 0;
    }








    public int findMin2(int[] nums) {
	if (nums.length == 0) return 0;
	if (nums.length == 1) return nums[0];
	int left = nums[0], right = nums[nums.length - 1];
	if (left < right) return left;
	int leftPointer = 0, rightPointer = nums.length;
	int result = 0;
	while (leftPointer < rightPointer) {
		int middlePointer = leftPointer + (rightPointer - leftPointer) / 2;
		int middle = nums[middlePointer];
		if (middlePointer > 0 && middle < nums[middlePointer - 1]) {
			result = middle;
			break;
		} else if (middle < left && middle < right) {
			rightPointer = middlePointer;
		} else {
			leftPointer = middlePointer;
		}
	}        

	return result;
    }
}

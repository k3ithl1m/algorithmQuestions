/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (40.99%)
 * Total Accepted:    238.3K
 * Total Submissions: 581.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */
class Solution {
    public int trap(int[] height) {
	int leftPtr = 0, rightPtr = height.length-1, totalTrapped = 0;
	if (height.length <= 1) return 0;
	int leftMax = height[leftPtr], rightMax = height[rightPtr];
	while(leftPtr < rightPtr) {
		if (leftMax <= rightMax && height[leftPtr] < leftMax) {
			totalTrapped += leftMax - height[leftPtr];
		} else if (rightMax < leftMax && height[rightPtr] < rightMax) {
			totalTrapped += rightMax - height[rightPtr];
		}

		if (leftMax <= rightMax) {
			leftPtr++;
			if (height[leftPtr] > leftMax) leftMax = height[leftPtr];
		} else  {
			rightPtr--;
			if (height[rightPtr] > rightMax) rightMax = height[rightPtr];
		}
	}        
	return totalTrapped;
    }
}

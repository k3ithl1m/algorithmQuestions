/*
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (32.90%)
 * Total Accepted:    211.4K
 * Total Submissions: 642.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
	int tempTarget = 0, dist =Integer.MAX_VALUE;
	int[] tempNums = Arrays.copyOf(nums, nums.length);
	Arrays.sort(tempNums);
	for (int i = 0; i < tempNums.length - 2; i++) {
	    int left = i + 1, right = tempNums.length - 1;
	    while (left < right) {
		int temp = tempNums[i] + tempNums[left] + tempNums[right];
		int tempCalc = Math.abs(temp - target);
		if (tempCalc < dist) {
		    dist = tempCalc;
		    tempTarget =temp;
		}
		if(temp>target) right--;
		else left++;
	    }
	}
	return tempTarget;
    }
}

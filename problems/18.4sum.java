/*
 * @lc app=leetcode id=18 lang=java
*
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (29.29%)
 * Total Accepted:    203.6K
 * Total Submissions: 694.8K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
	Arrays.sort(nums);
	ArrayList<List<Integer>> returnList = new ArrayList<>();
	int outerLeft = 0, outerRight = nums.length - 1;
	int innerLeft = outerLeft + 1, innerRight = outerRight - 1;
	for (int i = 0; i < nums.length - 3; i++) {
		for ( int j = i+1; j < nums.length - 2; j++) {
			innerLeft = j + 1;
			innerRight = outerRight;
			while( innerLeft < innerRight) {
				int total = nums[innerLeft] + nums[innerRight] +
						nums[i] + nums[j];
				if (total == target) {
					ArrayList result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[j]);
					result.add(nums[innerLeft]);
					result.add(nums[innerRight]);
					if (!returnList.contains(result))returnList.add(result);	
					innerLeft++;
				} else if (total < target) innerLeft++;
				else innerRight--;
			}
		}
	}        

	return returnList;
    }
}

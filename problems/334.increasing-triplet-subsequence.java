/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 *
 * algorithms
 * Medium (39.44%)
 * Total Accepted:    85.2K
 * Total Submissions: 216K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return
 * false.
 * 
 * Note: Your algorithm should run in O(n) time complexity and O(1) space
 * complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5]
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [5,4,3,2,1]
 * Output: false
 * 
 * 
 * 
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
 	if (nums.length <=2) return false;
	int smaller = Integer.MAX_VALUE, bigger = Integer.MAX_VALUE;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] > smaller && nums[i] > bigger) return true;
		else if (nums[i] > smaller && nums[i] < bigger) {
			bigger = nums[i];
		} else if (nums[i] < smaller) {
			smaller = nums[i];
		}
	}
	return false;
    }

}

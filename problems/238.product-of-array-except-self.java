/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (53.74%)
 * Total Accepted:    224.1K
 * Total Submissions: 416.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
	if (nums.length == 0) return new int[0];
	if (nums.length == 1) return new int[]{1};
	long total = 1;
	boolean foundZero = false;
	boolean foundTwoZero = false;
	for (int num : nums) {
		if (num != 0) {
			total*= num;        
		} else {
			if (foundZero) foundTwoZero = true;
			foundZero = true;
		}
	}
	int[] resultArray = new int[nums.length];
	if (foundTwoZero) return resultArray;
	for (int i = 0; i < nums.length; i++) {
		if (foundZero) {
			if (nums[i] == 0) resultArray[i] = (int) total;
		} else {
			resultArray[i] = (int) total/nums[i];
		}
	}
	return resultArray;
    }
}

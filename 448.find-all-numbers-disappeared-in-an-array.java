/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (52.54%)
 * Total Accepted:    132.7K
 * Total Submissions: 252.5K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * 
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
	int[] hash = new int[nums.length+1];
	int max = 0;        
	for (int i = 0; i < nums.length; i++) {
		hash[nums[i]]++;
	}
	ArrayList<Integer> resultList = new ArrayList<Integer>();
	for (int i = 1; i < hash.length; i++) {
		if (hash[i] == 0) resultList.add(i);
	}
	return resultList;
    }
}

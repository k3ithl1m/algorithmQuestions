/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 *
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * algorithms
 * Medium (36.70%)
 * Total Accepted:    43.5K
 * Total Submissions: 118K
 * Testcase Example:  '[1,2,3,4,5]\n4\n3'
 *
 * 
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array.  The result should also be sorted in ascending order.
 * If there is a tie,  the smaller elements are always preferred.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The value k is positive and will always be smaller than the length of the
 * sorted array.
 * ⁠Length of the given array is positive and will not exceed 104
 * ⁠Absolute value of elements in the array and x will not exceed 104
 * 
 * 
 * 
 * 
 * 
 * 
 * UPDATE (2017/9/19):
 * The arr parameter had been changed to an array of integers (instead of a
 * list of integers). Please reload the code definition to get the latest
 * changes.
 * 
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	int positionOfFirstX = 0;
	for (int i = 0; i < arr.length; i++) {
		if (arr[i] <= x) positionOfFirstX = i;
	}        
	
	List<Integer> resultList = new LinkedList<Integer>();
	resultList.add(arr[positionOfFirstX]);
	int left = positionOfFirstX-1, right = positionOfFirstX + 1;
	int count = k-1;
	while (count > 0) {
		if (right >= arr.length || (left >= 0 && x-arr[left] <= arr[right]-x)) 
			resultList.add(0, arr[left--]);
		else if (left < 0 || (right < arr.length && arr[right] - x < x-arr[left])) 
			resultList.add(resultList.size(), arr[right++]);
		count--;
	}
	return resultList;
    }
}

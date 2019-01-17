/*
 * @lc app=leetcode id=321 lang=java
 *
 * [321] Create Maximum Number
 *
 * https://leetcode.com/problems/create-maximum-number/description/
 *
 * algorithms
 * Hard (25.00%)
 * Total Accepted:    28K
 * Total Submissions: 111.9K
 * Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return
 * an array of the k digits.
 * 
 * Note: You should try to optimize your time and space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * 
 * 
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * 
 * 
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 * 
 */
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
	PriorityQueue<Integer> storeOf1 = new PriorityQueue<Integer>(20,Collections.reverseOrder());
	PriorityQueue<Integer> storeOf2 = new PriorityQueue<Integer>(20,Collections.reverseOrder());
	int[] result = new int[k];
	for (int i = 0; i < nums1.length; i++) {
		storeOf1.add(nums1[i]);
	}
	for (int i = 0; i < nums2.length; i++) {
		storeOf2.add(nums2[i]);
	}
	for (int j = 0; j < k; j++) {
		System.out.println(storeOf1.peek() + " " + storeOf2.peek());
		if (storeOf2.isEmpty()) {
			result[j] = storeOf1.remove();
			continue;
		} else if (storeOf1.isEmpty()) {
			result[j] = storeOf2.remove();
			continue;
		}
		if (storeOf1.peek() > storeOf2.peek()) {
			result[j] = storeOf1.remove();
		} else if (storeOf2.peek() > storeOf1.peek()) {
			result[j] = storeOf2.remove();
		} else {
			int temp = storeOf1.remove();
			result[j] = temp;
			storeOf2.remove();
			if (storeOf1.peek() > storeOf2.peek()) {
				storeOf2.add(temp);
			} else storeOf1.add(temp);
		}
	}
	return result;
    }
}

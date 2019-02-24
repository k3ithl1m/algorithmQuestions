/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (47.78%)
 * Total Accepted:    90.8K
 * Total Submissions: 189.6K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
	PriorityQueue<Integer> numberHeap = new PriorityQueue<>();
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			numberHeap.add(matrix[i][j]);
		}
	}       
	for (int i = 0; i < k-1; i++) {
		numberHeap.poll();
	}
	int result = numberHeap.peek();
	return result;
    }
}

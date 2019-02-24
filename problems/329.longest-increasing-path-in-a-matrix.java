/*
 * [329] Longest Increasing Path in a Matrix
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (38.49%)
 * Total Accepted:    71.7K
 * Total Submissions: 185.6K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = 
 * [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ] 
 * Output: 4 
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = 
 * [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ] 
 * Output: 4 
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally
 * is not allowed.
 * 
 */
class Solution {

    int currentMax = 1;
    public int longestIncreasingPath(int[][] matrix) {
	if (matrix.length <= 0 || matrix[0].length <= 0) return 0;
	int[][] dp = new int[matrix.length][matrix[0].length];        
	int max = 1;
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			int len = findMax(matrix, i, j, 0, dp);	
			max = Math.max(max, len);
		}
	}
	return max;
    }

    public int findMax(int[][] matrix, int i, int j, int count, int[][] dp) {
	if (dp[i][j] != 0) return dp[i][j];
	// if we have to constantly compare. it is good for us to have a variable
	// like max to constantly get the max.
	int max = 1;
	if (i -1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
		// we constantly compare the max with the value we get from 
		// the one around us.
		max = Math.max(findMax(matrix, i-1, j, count, dp) + 1, max);
	}	
	if (j -1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
		max = Math.max(findMax(matrix, i, j-1, count, dp) + 1, max);
	}
	if (j + 1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]) {
		max = Math.max(findMax(matrix, i, j+1, count, dp) +1, max);
	}
	if (i + 1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
		max = Math.max(findMax(matrix, i+1, j, count, dp)+1, max);
	}
	//when we are certain which is the max, we cache it. 
	dp[i][j] = max;
	return dp[i][j];
    }
}

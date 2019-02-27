/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (32.19%)
 * Total Accepted:    118K
 * Total Submissions: 366.6K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 * 
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
	if (matrix.length == 0) return 0;
	int[][] matrixCache = new int[matrix.length+1][matrix[0].length+1];
	int max = 0;
	for (int i = 1; i <= matrix.length; i++) {
		for (int j = 1; j <= matrix[0].length; j++) {
			if (matrix[i-1][j-1] == '1') {
				matrixCache[i][j] = Math.min(Math.min(matrixCache[i][j-1], matrixCache[i-1][j-1]),
							matrixCache[i-1][j]) + 1;
				max =Math.max(max, matrixCache[i][j]);
			}
		}
	}
	return max*max;
    }

    public int maximalSquare2(char[][] matrix) {
	if (matrix.length == 0) return 0;
	int[] matrixCache = new int[matrix[0].length];
	int max = 0;
	for (int i = 0; i < matrix.length; i++) {
		for (int j = matrix[0].length - 1; j >= 0; j--) {
			if (i == 0) {
				matrixCache[j] = Character.getNumericValue(matrix[i][j]);
			} else {
				matrixCache[j] = Character.getNumericValue(matrix[i][j]) 
					+ Math.min(Character.getNumericValue(matrix[i-1][j]),
								Math.min(matrixCache[j],
								(j > 0) ? matrixCache[j-1]: 0));
			}
			max = Math.max(max, matrixCache[j]);
		}
	}
	return max*max;
    }
}

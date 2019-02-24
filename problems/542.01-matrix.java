/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (34.46%)
 * Total Accepted:    35.9K
 * Total Submissions: 104K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * Example 1: 
 * Input:
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * Output:
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 
 * Example 2: 
 * Input:
 * 
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 
 * Output:
 * 
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 
 * 
 * 
 * Note:
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 * 
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
	int[][] resultMatrix = new int[matrix.length][matrix[0].length];
	for (int i = 0; i < matrix.length; i++) {
		Arrays.fill(resultMatrix[i], -1);
	}        
	boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if (resultMatrix[i][j] == -1) {
				resultMatrix[i][j] = findDistance(matrix, resultMatrix, i, j, visitedMatrix);
			}
		}
	}
	return resultMatrix;
    }

    private int findDistance(int[][] matrix, int[][] resultMatrix, int i, int j, boolean[][] visitedMatrix) {
	if (matrix[i][j] == 0) {
		resultMatrix[i][j] = 0;
		return 0;
	}
	if (resultMatrix[i][j] != -1) return resultMatrix[i][j];
	if (visitedMatrix[i][j]) return Integer.MAX_VALUE - 1;
	
	int minNumber = Integer.MAX_VALUE;
	visitedMatrix[i][j] = true;
	if (i-1 >= 0) 
		minNumber = Math.min(minNumber, findDistance(matrix, resultMatrix, i-1, j, visitedMatrix) + 1);	
	if (j-1 >= 0) 
		minNumber = Math.min(minNumber, findDistance(matrix, resultMatrix, i, j-1, visitedMatrix) + 1);	
	if (i+1 < matrix.length) 
		minNumber = Math.min(minNumber, findDistance(matrix, resultMatrix, i+1, j, visitedMatrix) + 1);	
	if (j+1 < matrix[0].length) 
		minNumber = Math.min(minNumber, findDistance(matrix, resultMatrix, i, j+1, visitedMatrix) + 1);	

	resultMatrix[i][j] = minNumber;
	return minNumber;
    }
}

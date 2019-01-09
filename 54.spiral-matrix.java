/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (29.10%)
 * Total Accepted:    196K
 * Total Submissions: 673.6K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
enum Direction {
	Left, Right, Up, Down;
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
	//edge cases
	boolean[][] matrixVisited = boolean[matrix.length][matrix[0].length];
	Direction currentDirection = Direction.Right;	        
	ArrayList<Integer> result = new ArrayList<Integer>();
	int row = 0, col = 0;
	while (checkVisited(row, col, matrixVisited)){
		if (currentDirection == Direction.Right) {
			row++;
		} else if (currentDirection == Direction.Left) {
			row--;
		} else if (currentDirection == Direction.Down) {
			col++;
		} else col--;
		result.add(matrix[row][col]);
		matrixVisited[row][col] = true;
		if(currentDirection == Direction.Right && 
			(row + 1 >= matrix.length || matrixVisited[row+1][col])) {
			currentDirection = Direction.Down;
		} else if (currentDirection == Direction.Down && 
				(col + 1 >= matrix[0].length || matrixVisited[row][col+1])) {
			currentDirection = Direction.Left;
		} else if (currentDirection == Direction.Left && 
				(row - 1 < 0 || matrixVisited[row-1][col]) {
			currentDirection = Direction.Up;
		} else if (currentDirection == Direction.Up && 
				(col - 1 < 0 || matrixVisited[row][col-1]) {
			currentDirection = Direction.Right;
		}
	}
	return result;
    }

    public boolean checkVisited(int row, int col, boolean[][] matrixVisited) {
    }
}

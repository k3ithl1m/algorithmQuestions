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
//    public List<Integer> spiralOrder(int[][] matrix) {
//	//edge cases
//	if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<Integer>();
//	boolean[][] matrixVisited = new boolean[matrix.length][matrix[0].length];
//	Direction currentDirection = Direction.Right;	        
//	ArrayList<Integer> result = new ArrayList<Integer>();
//	int row = 0, col = 0;
//	while (checkVisited(row, col, matrixVisited)){
//		result.add(matrix[row][col]);
//		matrixVisited[row][col] = true;
//		if(currentDirection == Direction.Right && 
//			(row + 1 >= matrix.length || matrixVisited[row+1][col])) {
//			currentDirection = Direction.Down;
//		} else if (currentDirection == Direction.Down && 
//				(col + 1 >= matrix[0].length || matrixVisited[row][col+1])) {
//			currentDirection = Direction.Left;
//		} else if (currentDirection == Direction.Left && 
//				(row - 1 < 0 || matrixVisited[row-1][col])) {
//			currentDirection = Direction.Up;
//		} else if (currentDirection == Direction.Up && 
//				(col - 1 < 0 || matrixVisited[row][col-1])) {
//			currentDirection = Direction.Right;
//		}
//		if (currentDirection == Direction.Right) {
//			row++;
//		} else if (currentDirection == Direction.Left) {
//			row--;
//		} else if (currentDirection == Direction.Down) {
//			col++;
//		} else col--;
//	}
//	return result;
 //   }

    public boolean checkVisited(int row, int col, boolean[][] matrixVisited) {
	boolean res=false;
	if (row-1 >= 0) {
		if(matrixVisited[row-1][col]) res = false;
		else return true;	
	}
	if (col-1 >= 0) {
		if(matrixVisited[row][col-1]) res = false;
		else return true;
	}

	if(col+1<matrixVisited[0].length) {
		if(matrixVisited[row][col+1]) res = false;
		else return true;
	}

	if(row+1<matrixVisited.length) {
		if(matrixVisited[row+1][col]) res = false;
		else return true;
	}

		System.out.println("I'm here");
	return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
}

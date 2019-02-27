/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 *
 * algorithms
 * Medium (30.75%)
 * Total Accepted:    61.5K
 * Total Submissions: 199.5K
 * Testcase Example:  '["NumMatrix","sumRegion","sumRegion","sumRegion"]\n[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]'
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * 
 * 
 * 
 * The above rectangle (with the red border) is defined by (row1, col1) = (2,
 * 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * 
 * Example:
 * 
 * Given matrix = [
 * ⁠ [3, 0, 1, 4, 2],
 * ⁠ [5, 6, 3, 2, 1],
 * ⁠ [1, 2, 0, 1, 5],
 * ⁠ [4, 1, 0, 1, 7],
 * ⁠ [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * 
 */
class NumMatrix {

    int[][] cache;
    boolean empty = false;
    public NumMatrix(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		empty = true;
	} else {
		cache = new int[matrix.length][matrix[0].length+1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				cache[i][j+1] = matrix[i][j] + cache[i][j];
			}
		}
	}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
	int total = 0;
	if (empty) return 0;
	for (int i = row1; i <= row2; i++) {
		total += cache[i][col2+1] - cache[i][col1];
	}
	return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

/*
 * [661] Image Smoother
 *
 * https://leetcode.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (47.00%)
 * Total Accepted:    23.4K
 * Total Submissions: 49.7K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you
 * need to design a smoother to make the gray scale of each cell becomes the
 * average gray scale (rounding down) of all the 8 surrounding cells and
 * itself.  If a cell has less than 8 surrounding cells, then use as many as
 * you can.
 * 
 * Example 1:
 * 
 * Input:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * Output:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * 
 * 
 * 
 * Note:
 * 
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 * 
 * 
 */
class Solution {
    public int[][] imageSmoother(int[][] M) {
      int m = M.length, n = M[0].length;
      int[][] newM = new int[m][n];
      for (int i = 0; i < M.length; i++) {
	for (int j = 0; j < n; j++) {
	  int count = 0;
	  for (int row = i - 1; row <= i + 1; row++) {
	    for (int col = j - 1; col <= j + 1; col++) {
	      if (row >= 0 && row < m && col >= 0 && col < n) {
		newM[i][j] += M[row][col];
		count++;
	      }
	    }	
	  }
	  newM[i][j] /= count;
	}
      }  
      return newM;
    }
}
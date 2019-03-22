/*
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (31.54%)
 * Total Accepted:    104.8K
 * Total Submissions: 331.2K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 *
 * Example:
 *
 *
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 *
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
	if (matrix.length == 0 || matrix[0].length == 0) return 0;
	int[] height = new int[matrix[0].length];
	int maxArea = 0;
	for (int i = 0; i < matrix.length; i++) {
		Stack<Integer> positionStack = new Stack<>();
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[i][j] == '1') height[j]++;
			else height[j] = 0;
		}
		
		int k = 0;
		while(k <= height.length) {
			int currentHeight = (k == height.length) ? 0 : height[k];
			if (positionStack.isEmpty() || currentHeight >= height[positionStack.peek()]) {
				positionStack.push(k);
				k++;
			} else {
				int popped = positionStack.pop();
				int currentMaxArea = height[popped] * 
					((positionStack.isEmpty()) ? k : k - 1 - positionStack.peek());
				maxArea = Math.max(currentMaxArea, maxArea);
			}
		}
	}

	return maxArea;
    }
}

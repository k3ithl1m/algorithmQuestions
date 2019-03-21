/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (30.30%)
 * Total Accepted:    160.1K
 * Total Submissions: 527.7K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
	if (heights.length == 0) return 0;
	int max = 0;
	Stack<Integer> positionStack = new Stack<>();
	int i = 0;
	while (i <= heights.length) {
		int height = (i == heights.length) ? 0 : heights[i];
		if (positionStack.isEmpty() || height >= heights[positionStack.peek()]) {
			positionStack.push(i);
			i++;
		} else {
			int popped = positionStack.pop();
			// We take the previous tallest height, and multiply it by rightindex(currentPosition)
			// with left, the position before it.
			int currentMaxHeight = heights[popped] * 
				(positionStack.isEmpty() ? i : i - 1 - positionStack.peek());
			max = Math.max(max, currentMaxHeight);
			//keeps the position in the same place
		}
	}        

	return max;
    }
}

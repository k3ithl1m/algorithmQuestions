/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (37.95%)
 * Total Accepted:    165.1K
 * Total Submissions: 435.1K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
	int min = Integer.MAX_VALUE;
	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	List<Integer> rowList = new ArrayList<Integer>();        
	rowList.add(triangle.get(0).get(0));
	resultList.add(rowList);
	if (triangle.size() < 2) return rowList.get(0);
	for (int i = 1; i < triangle.size(); i++) {
		List<Integer> currentList = triangle.get(i);
		System.out.println(resultList.size());
		List<Integer> previousResList = resultList.get(i-1);
		rowList = new ArrayList<Integer>();
		//gets the first one and implement it
		rowList.add(resultList.get(i-1).get(0)+currentList.get(0));
		for (int j = 1; j < currentList.size()-1; j++) {
			int minRow = Integer.MAX_VALUE;
			int leftValue = previousResList.get(j-1) + currentList.get(j);
			int rightValue = previousResList.get(j) + currentList.get(j);
			rowList.add(Math.min(leftValue, rightValue));
		}
		//gets the last one and implement it
		rowList.add(resultList.get(i-1).get(resultList.size() - 1)+currentList.get(currentList.size()-1));
		resultList.add(rowList);
	}

	List<Integer> lastRow = resultList.get(resultList.size() -1);
	for (int i = 0; i < lastRow.size(); i++) {
		min = Math.min(min, lastRow.get(i));
	}

	return min;
	
    }
}

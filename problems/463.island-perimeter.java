/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (59.67%)
 * Total Accepted:    115.3K
 * Total Submissions: 193K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e.,
 * one or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter
 * of the island.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * Output: 16
 * 
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * 
 * 
 * 
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
    	int totalPerimeter = 0;
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j<grid[0].length; j++) {
			if (grid[i][j] == 1) {
				totalPerimeter += 4;
				if (i-1 >= 0 && grid[i-1][j] == 1) totalPerimeter--;
				if (i+1 < grid.length && grid[i+1][j] == 1) totalPerimeter--;
				if (j-1 >= 0 && grid[i][j-1] == 1) totalPerimeter--;
				if (j+1 < grid[0].length && grid[i][j+1] == 1) totalPerimeter--;
			}
		}
	}        
	return totalPerimeter;
    }

    public int dfs(int[][] grid, boolean[][] visitedIsland, int i, int j, int totalPerimeter) {
	if (visitedIsland[i][j]) return totalPerimeter;
	visitedIsland[i][j] = true;
	
	System.out.println(i + " " + j+ " " + totalPerimeter);
	if (i-1>=0 && grid[i-1][j] == 1) {
		totalPerimeter = dfs(grid, visitedIsland, i-1, j, totalPerimeter);
	} else totalPerimeter++;
	
	if (i+1<grid.length && grid[i+1][j] == 1) {
		totalPerimeter = dfs(grid, visitedIsland, i+1, j, totalPerimeter);
	} else totalPerimeter++;
	if (j+1<grid[0].length && grid[i][j+1] == 1) {
		totalPerimeter = dfs(grid, visitedIsland, i, j+1, totalPerimeter);
	} else totalPerimeter++;
	if (j-1>=0 && grid[i][j-1] == 1) {
		totalPerimeter = dfs(grid, visitedIsland, i, j-1, totalPerimeter);
	} else totalPerimeter++;
	return totalPerimeter;
    }
}

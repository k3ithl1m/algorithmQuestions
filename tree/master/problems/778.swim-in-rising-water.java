/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 *
 * https://leetcode.com/problems/swim-in-rising-water/description/
 *
 * algorithms
 * Hard (46.79%)
 * Total Accepted:    10.5K
 * Total Submissions: 22.4K
 * Testcase Example:  '[[0,2],[1,3]]'
 *
 * On an N x N grid, each square grid[i][j] represents the elevation at that
 * point (i,j).
 * 
 * Now rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually are at most t. You can
 * swim infinite distance in zero time. Of course, you must stay within the
 * boundaries of the grid during your swim.
 * 
 * You start at the top left square (0, 0). What is the least time until you
 * can reach the bottom right square (N-1, N-1)?
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have
 * a higher elevation than t = 0.
 * 
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 * ⁠0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * 
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= N <= 50.
 * grid[i][j] is a permutation of [0, ..., N*N - 1].
 * 
 * 
 */
class Solution {
    public int swimInWater(int[][] grid) {
	PriorityQueue<Elevation> elevationQ = new PriorityQueue<>(new Comparator<Elevation>() {
		@Override
		public int compare(Elevation a, Elevation b) {
			return a.e - b.e;
		}
	});
	boolean[][] visited = new boolean[grid.length][grid[0].length];
	visited[0][0] = true;
	elevationQ.offer(new Elevation(0,0,grid[0][0]));
	int ans = grid[grid.length-1][grid[0].length-1];
	int[][] direction = new int[][]{ {0,1}, {0,-1},{1,0},{-1,0}};
	while(!elevationQ.isEmpty()) {
		Elevation currentElevation = elevationQ.poll();
		ans = Math.max(currentElevation.e, ans);
		for (int[] dir: direction) {
			int newX = currentElevation.x + dir[0], newY = currentElevation.y + dir[1];
			if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) continue;
			if (visited[newX][newY]) continue;
			if (newX == grid.length - 1 && newY == grid[0].length - 1) {
				return ans;
			}
			visited[newX][newY] = true;
			elevationQ.offer(new Elevation(newX,newY,grid[newX][newY]));
		}
	}
	return ans;
    }
}

class Elevation {
	int x;
	int y;
	int e;
	public Elevation(int x, int y, int e) {
		this.x = x;
		this.y = y;
		this.e = e;
	}
}

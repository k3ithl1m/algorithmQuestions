/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 *
 * https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * algorithms
 * Hard (38.56%)
 * Total Accepted:    23.3K
 * Total Submissions: 60.5K
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * Given an m x n matrix of positive integers representing the height of each
 * unit cell in a 2D elevation map, compute the volume of water it is able to
 * trap after raining.
 * 
 * 
 * 
 * Note:
 * 
 * Both m and n are less than 110. The height of each unit cell is greater than
 * 0 and is less than 20,000.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given the following 3x6 height map:
 * [
 * ⁠ [1,4,3,1,3,2],
 * ⁠ [3,2,1,3,2,4],
 * ⁠ [2,3,3,2,3,1]
 * ]
 * 
 * Return 4.
 * 
 * 
 * 
 * 
 * The above image represents the elevation map
 * [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 * 
 * 
 * 
 * 
 * 
 * After the rain, water is trapped between the blocks. The total volume of
 * water trapped is 4.
 * 
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
    	if (heightMap.length == 0 || heightMap[0].length == 0) return 0;
	boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];    
	int m = heightMap.length;
	int n = heightMap[0].length;
	PriorityQueue<Node> maxTracker = new PriorityQueue<Node>(new Comparator<Node>(){
			public int compare(Node a, Node b) {
				return a.height - b.height;
			}	
		});
	for (int i = 0; i < heightMap.length; i++) {
		maxTracker.add(new Node(i, 0, heightMap[i][0]));
		maxTracker.add(new Node(i, heightMap[0].length-1, heightMap[i][heightMap[0].length-1]));
		visited[i][0] = true;
		visited[i][heightMap[0].length-1] = true;
	}
	for (int i = 0; i < heightMap[0].length; i++) {
		maxTracker.add(new Node(0, i, heightMap[0][i]));
		maxTracker.add(new Node(heightMap.length - 1, i, heightMap[heightMap.length-1][i]));
		visited[0][i] = true;
		visited[heightMap.length - 1][i] = true;
	}

	int maxHeight = 0;
	int totalTrapped = 0;
	
	int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	while(!maxTracker.isEmpty()) {
		Node currentNode = maxTracker.remove();
		if (currentNode.height > maxHeight) maxHeight = currentNode.height;
		int left = currentNode.x - 1;
		int right = currentNode.x + 1;
		int top = currentNode.y - 1;
		int down = currentNode.y + 1;
		if (left >= 0 && !visited[currentNode.x-1][currentNode.y]) {
			int leftHeight = heightMap[currentNode.x-1][currentNode.y];
			if (leftHeight < maxHeight) {
				totalTrapped += maxHeight - leftHeight;
			}
			visited[left][currentNode.y] = true;
			maxTracker.add(new Node(left, currentNode.y, heightMap[left][currentNode.y]));
		}
		if (top >= 0 && !visited[currentNode.x][currentNode.y-1]) {
			int topHeight = heightMap[currentNode.x][top];
			if (topHeight < maxHeight) {
				totalTrapped += maxHeight - topHeight;
			}
			visited[currentNode.x][top] = true;
			maxTracker.add(new Node(currentNode.x, top, heightMap[currentNode.x][top]));
		}
		if (right < heightMap.length && !visited[right][currentNode.y]) {
			int rightHeight = heightMap[right][currentNode.y];
			if (rightHeight < maxHeight) {
				totalTrapped += maxHeight - rightHeight;
			}
			visited[right][currentNode.y] = true;
			maxTracker.add(new Node(right, currentNode.y, heightMap[right][currentNode.y]));
		}
		if (down < heightMap[0].length && !visited[currentNode.x][down]) {
			int downHeight = heightMap[currentNode.x][down];
			if (downHeight < maxHeight) {
				totalTrapped += maxHeight - downHeight;
			}
			visited[currentNode.x][down] = true;
			maxTracker.add(new Node(currentNode.x, down, heightMap[currentNode.x][down]));
		}

//		Node node = maxTracker.remove();
//		for(int[] dir: dirs) {
//			int row = node.x + dir[0];
//			int col = node.y + dir[1];
//			if (row>=0 && row < m && col >= 0 && col < n && !visited[row][col]) {
//				visited[row][col] = true;
//				totalTrapped += Math.max(0, node.height - heightMap[row][col]);
//				maxTracker.add(new Node(row, col, Math.max(heightMap[row][col], node.height)));
//			}
//		}
	}

	return totalTrapped;
    }
}

class Node {
	int x;
	int y;
	int height;
	public Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.height = val;
	}
}

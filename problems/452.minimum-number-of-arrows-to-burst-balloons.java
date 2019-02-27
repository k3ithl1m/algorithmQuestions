/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 *
 * algorithms
 * Medium (45.66%)
 * Total Accepted:    33.6K
 * Total Submissions: 73.5K
 * Testcase Example:  '[[10,16],[2,8],[1,6],[7,12]]'
 *
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and
 * hence the x-coordinates of start and end of the diameter suffice. Start is
 * always smaller than end. There will be at most 104 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if
 * xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be
 * shot. An arrow once shot keeps travelling up infinitely. The problem is to
 * find the minimum number of arrows that must be shot to burst all balloons. 
 * 
 * Example:
 * 
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons
 * [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two
 * balloons).
 * 
 * 
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
	if (points.length == 0) return 0;
	if (points.length == 1) return 1;
	PriorityQueue<int[]> storeBalloons = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] pointA, int[] pointB) {
			return pointA[0] - pointB[0];
		}
	});        

	for (int i = 0; i < points.length; i++) {
		storeBalloons.add(points[i]);
	}
	int totalShot = 0;
	while(storeBalloons.isEmpty() == false) {
		int start = storeBalloons.peek()[0], end = storeBalloons.peek()[1];
		storeBalloons.poll();
		while (storeBalloons.isEmpty() == false) {
			int nextPoint = storeBalloons.peek()[0];
			if (nextPoint > end) {
				break;
			}
			end = Math.min(storeBalloons.peek()[1], end);
			storeBalloons.poll();
		}
		totalShot++;
	}
	return totalShot;
    }
}

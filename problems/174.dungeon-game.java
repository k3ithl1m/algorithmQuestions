/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (26.42%)
 * Total Accepted:    61.8K
 * Total Submissions: 233.8K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 * 
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 * 
 * 
 * 
 * 
 * -2 (K)
 * -3
 * 3
 * 
 * 
 * -5
 * -10
 * 1
 * 
 * 
 * 10
 * 30
 * -5 (P)
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
	if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
	
	int m = dungeon.length;
	int n = dungeon[0].length;
	int[][] dungeonCache = new int[dungeon.length][dungeon[0].length];
	for (int i = dungeon.length - 1; i >= 0; i--) {
		for (int j = dungeon[0].length - 1; j >= 0; j--) {
			if (i == m-1 && j == n-1) {
				dungeonCache[i][j] = Math.max(1-dungeon[i][j], 1);
			} else if (i == m-1) 
				dungeonCache[i][j] = Math.max(dungeonCache[i][j+1] - dungeon[i][j], 1);
			else if (j == n - 1) 
				dungeonCache[i][j] = Math.max(dungeonCache[i+1][j] - dungeon[i][j], 1);
			else {
				int down = Math.max(dungeonCache[i+1][j] - dungeon[i][j], 1);
				int right = Math.max(dungeonCache[i][j+1] - dungeon[i][j], 1);
				dungeonCache[i][j] = Math.min(down, right);
			}
		}
	}

	return dungeonCache[0][0];
    }
	
}

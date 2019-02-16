/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * algorithms
 * Medium (42.11%)
 * Total Accepted:    93.9K
 * Total Submissions: 223K
 * Testcase Example:  '[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]'
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state. The next state is created by applying the above
 * rules simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously.
 * 
 * Example:
 * 
 * 
 * Input: 
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output: 
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 
 */
class Solution {
    public void gameOfLife(int[][] board) {
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			int isAlive = board[i][j];
			int numCellsAround = 0;
			for (int k = i - 1; k <= i+1; k++) {
				for (int l = j - 1; l <= j+1; l++) {
					if (k==i && l==j) continue;
					if (k>=0 && k<board.length && l>=0 && l<board[0].length) {
						numCellsAround += board[k][l]&1;
					}
				}
			}
			board[i][j] = (isAlive==1) ?
					(numCellsAround < 2 || numCellsAround > 3) ? 1 : 3 :
					(numCellsAround == 3) ? 2 : 0;
		}
	}

	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			board[i][j] = board[i][j] >> 1;
		}
	}
    }

    public void gameOfLife2(int[][] board) {
	int[][] tempBoard = new int[board.length][board[0].length];
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			tempBoard[i][j] = board[i][j];
		}
	}

	
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			int isAlive = board[i][j];
			int numCellsAround = 0;
			for (int k = i - 1; k <= i+1; k++) {
				for (int l = j - 1; l <= j+1; l++) {
					if (k==i && l==j) continue;
					if (k>=0 && k<board.length && l>=0 && l<board[0].length) {
						numCellsAround += tempBoard[k][l];
					}
				}
			}
			board[i][j] = (isAlive==1) ?
					(numCellsAround < 2 || numCellsAround > 3) ? 0 : 1 :
					(numCellsAround == 3) ? 1 : 0;
		}
	}

    }
}

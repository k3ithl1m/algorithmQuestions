/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (28.73%)
 * Total Accepted:    204.5K
 * Total Submissions: 707.8K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) 
	for (int j = 0; j < board[0].length; j++) 
	  if (board[i][j] == word.charAt(0)) 
	  if (exist(word, 0, board, i, j)) return true;
      return false; 
    }

    public boolean exist(String word, int pos, char[][] board, int row, int col) {
      if (pos == word.length()) return true;
      if (row<0||col<0||row==board.length||col==board[row].length) return false;
      if (board[row][col] != word.charAt(pos)) return false;
      board[row][col] ^= 256;
      boolean exist =exist(word, pos+1, board, row+1, col) ||
	     exist(word, pos+1, board, row, col+1) ||
	     exist(word, pos+1, board, row-1, col) ||
	     exist(word, pos+1, board, row, col - 1);
      
      board[row][col] ^= 256;
      return exist;
    }
}

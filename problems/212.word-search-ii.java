/*
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (26.59%)
 * Total Accepted:    88.3K
 * Total Submissions: 331.3K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * Example:
 * 
 * 
 * Input: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
	TrieNode head = new TrieNode();
	
	for (int i = 0; i < words.length; i++) {
		TrieNode temp = head;
		for (char c : words[i].toCharArray()) {
			temp.setNode(c);
			temp = temp.getNode(c);
		}
		temp.end = true;
		temp.val = words[i];
	}	        

	ArrayList<String> arStr = new ArrayList<String>();
	boolean[][] boardcheck = new boolean[board.length][board[0].length];
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			checkboard(board, boardcheck, head.getNode(board[i][j]), i, j, arStr);
		}
	}
	return arStr;
    }

    public void checkboard(char[][] board, boolean[][] boardcheck, TrieNode tn, int i, int j, ArrayList<String> arStr) {
	if (tn == null || boardcheck[i][j]) return;
	if (tn.end && !tn.used) { 
		arStr.add(tn.val);
		tn.used = true;
	}
		boardcheck[i][j] = true;
		if (i - 1 >= 0) checkboard(board, boardcheck, tn.getNode(board[i-1][j]), i-1, j, arStr);
		if (j - 1 >= 0) checkboard(board, boardcheck, tn.getNode(board[i][j-1]), i, j-1, arStr);
		if (i + 1 < board.length) checkboard(board, boardcheck, tn.getNode(board[i+1][j]), i + 1, j, arStr);
		if (j + 1 < board[0].length) checkboard(board, boardcheck, tn.getNode(board[i][j+1]), i, j + 1, arStr);
		boardcheck[i][j] = false;
    }
}

class TrieNode {
	TrieNode[] nodeAr;
	boolean end = false;
	boolean used = false;
	String val;
	TrieNode() {
		nodeAr = new TrieNode[26];
	}

	TrieNode getNode(char c) {
		return nodeAr[c - 'a'];
	}
	
	boolean setNode(char c) {
		if (nodeAr[c - 'a'] != null) return false;
		else {
			nodeAr[c-'a'] = new TrieNode();
			return true;
		}
	}
}

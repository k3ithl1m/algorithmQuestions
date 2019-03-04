/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (36.03%)
 * Total Accepted:    153.7K
 * Total Submissions: 426.3K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
	if (word2.length() == 0) return word1.length();
	if (word1.length() == 0) return word2.length();
	int[][] wordLengthCache = new int[word1.length()+1][word2.length()+1];
	for (int i = 0; i < word1.length()+1; i++) {
		wordLengthCache[i][0] = i;
	}

	for (int i = 0; i < word2.length()+1; i++) {
		wordLengthCache[0][i] = i;
	}
	
	for (int i = 1; i <=word1.length(); i++) {
		char charOfWord1 = word1.charAt(i-1);
		for (int j = 1; j <=word2.length(); j++) {
			char charOfWord2 = word2.charAt(j-1);
			if (charOfWord1 == charOfWord2) wordLengthCache[i][j] = wordLengthCache[i-1][j-1];
			else {
				wordLengthCache[i][j] = Math.min(wordLengthCache[i-1][j], Math.min(
							wordLengthCache[i-1][j-1], wordLengthCache[i][j-1]))+1;
			}
		}
	}
	return wordLengthCache[word1.length()][word2.length()];
    }
}

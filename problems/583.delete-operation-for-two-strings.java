/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (43.94%)
 * Total Accepted:    25.7K
 * Total Submissions: 58.5K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * 
 * Given two words word1 and word2, find the minimum number of steps required
 * to make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * 
 * Example 1:
 * 
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 * 
 * 
 * 
 * Note:
 * 
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
	if (word1 == null || word1.length() == 0) return word2.length();
	if (word2 == null || word2.length() == 0) return word1.length(); 
	int posOf1 = 0;
	int posOf2 = 0;
	int countOfSameChar = 0;
	while (posOf1 < word1.length()) {
		for (int j = posOf2; j < word2.length(); j++) {
			if (word1.charAt(posOf1) == word2.charAt(j)) {
				System.out.println(word2.charAt(j));
				posOf2 = j+1;
				countOfSameChar++;
				break;
			}
		}
		posOf1++;
	}
	System.out.println(countOfSameChar);
	return word1.length() + word2.length() - 2*countOfSameChar;
    }
}

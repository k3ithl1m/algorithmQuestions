/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * algorithms
 * Medium (40.40%)
 * Total Accepted:    15.6K
 * Total Submissions: 38.6K
 * Testcase Example:  '"abcde"\n["a","bb","acd","ace"]'
 *
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 * 
 * 
 * Example :
 * Input: 
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S:
 * "a", "acd", "ace".
 * 
 * 
 * Note:
 * 
 * 
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 * 
 * 
 */
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
	if (words.length == 0) return 0;
	if (S.length() == 0) return 0;
	int count = 0;
	for (int i = 0; i < words.length; i++) {
		String currentWord = words[i];
		int sIndex = 0;
		int tIndex = 0;
		while (sIndex < S.length()) {
			if (S.charAt(sIndex) == currentWord.charAt(tIndex)) {
				tIndex++;
				if (tIndex >= currentWord.length()) {
					count++;
					break;
				}
			}
			sIndex++;
		}
	}
	return count;
    }
}

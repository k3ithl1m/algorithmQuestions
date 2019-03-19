/*
 * @lc app=leetcode id=890 lang=java
 *
 * [890] Find and Replace Pattern
 *
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 *
 * algorithms
 * Medium (70.19%)
 * Total Accepted:    22.5K
 * Total Submissions: 32.1K
 * Testcase Example:  '["abc","deq","mee","aqq","dkd","ccc"]\n"abb"'
 *
 * You have a list of words and a pattern, and you want to know which words in
 * words matches the pattern.
 * 
 * A word matches the pattern if there exists a permutation of letters p so
 * that after replacing every letter x in the pattern with p(x), we get the
 * desired word.
 * 
 * (Recall that a permutation of letters is a bijection from letters to
 * letters: every letter maps to another letter, and no two letters map to the
 * same letter.)
 * 
 * Return a list of the words in words that match the given pattern. 
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a ->
 * m, b -> e, ...}. 
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a
 * permutation,
 * since a and b map to the same letter.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * 
 * 
 * 
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
	ArrayList<String> resultList = new ArrayList<>();
	if (words.length == 0 || pattern.length() == 0) return resultList;
	int[] storePattern = new int[pattern.length()];
	int patternStartVal = pattern.charAt(0);
	int patternLength = pattern.length();
	for (int i = 0; i < pattern.length(); i++) {
		storePattern[i] = pattern.charAt(i) - patternStartVal;
		System.out.println(storePattern[i]);
	}        

		
	for (int i = 0; i < words.length; i++) {
		String currentWord = words[i];
		if (currentWord.length() > patternLength || currentWord.length() < patternLength) continue;
		else {
			patternStartVal = currentWord.charAt(0);
			boolean patternSame = true;
			for (int j = 0; j < currentWord.length(); j++) {
				if (currentWord.charAt(j) - patternStartVal != storePattern[j]) {
					patternSame = false;
					break;
				}
			}
			if (patternSame) resultList.add(currentWord);
		}
	}

	return resultList;
    }
}

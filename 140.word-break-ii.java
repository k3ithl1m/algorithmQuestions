/*
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (26.01%)
 * Total Accepted:    138.2K
 * Total Submissions: 530.5K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
	HashSet<String> hs = new HashSet<String>();
	for (String str: wordDict.toArray(new String[wordDict.size()])) {
		hs.add(str);
	}        

	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> resultAr = new ArrayList<String>();
	boolean[] wordExistAr = new boolean[s.length() + 1];
	boolean isExist = wordBreak2(s, hs, wordExistAr);
	if (!isExist) return result;
	else {
		System.out.println("we're here");
		addWordToResult(s, hs, wordExistAr, result, resultAr, 0);
		return result;
	}
    }

    public boolean wordBreak2(String s, HashSet<String> hs, boolean[] wordExistAr) {
	wordExistAr[0] = true;
	for (int i = 0; i < s.length() + 1; i++) {
		for (int j = 0; j < i; j++) {
			if (wordExistAr[j] && hs.contains(s.substring(j,i))) {
				System.out.println(s.substring(j,i));
				wordExistAr[i] = true;
			}
		}
	}
	return wordExistAr[wordExistAr.length - 1];
    }

    public void addWordToResult(String s, HashSet<String> wordDict, boolean[] wordExistAr, ArrayList<String> result, ArrayList<String> resultAr, int left) {
	if (left >= s.length()) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < resultAr.size() - 1; i++) {
			sb.append(resultAr.get(i));
			sb.append(" ");
		}
		sb.append(resultAr.get(resultAr.size()-1));
		result.add(sb.toString());
		return;
	}

	for (int j = left; j < wordExistAr.length; j++) {
		if (wordExistAr[j] && wordDict.contains(s.substring(left, j))) {
			resultAr.add(s.substring(left, j));
			addWordToResult(s, wordDict, wordExistAr, result, resultAr, j);
			resultAr.remove(resultAr.size() - 1);
		}
	}
	return;
    }
}

/*
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (32.32%)
 * Total Accepted:    247.9K
 * Total Submissions: 760.5K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
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
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
	boolean[] sAr = new boolean[s.length()];
	
	ArrayList<Integer> ar = new ArrayList<Integer>();
	ar.add(0);
	
	sAr[0] = true;
	for (int i = 0; i <= sAr.length; i++) {
//		for (int j = 0; j < i; j++) {
//			if (sAr[j] && wordDict.contains(s.substring(j, i))) {
//				if (i<sAr.length) sAr[i] = true;
//				else return true;
//			}
//		}

		for (int j = 0; j < ar.size(); j++) {
			if(wordDict.contains(s.substring(ar.get(j), i))){
				System.out.println(ar.get(j));
				if (i<s.length() && !ar.contains(i)) {
					ar.add(i);
					continue;
				}
				else if (i == s.length()) {

				System.out.println(s.substring(ar.get(j), i));
					return true;
				}
			}
		}
	}

	return false;
    }
}

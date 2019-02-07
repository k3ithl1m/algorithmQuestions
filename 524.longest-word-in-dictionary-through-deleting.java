/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (44.67%)
 * Total Accepted:    36.1K
 * Total Submissions: 80.7K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1:
 * 
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * 
 * 
 * 
 * Note:
 * 
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * 
 * 
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
	if (s.length() == 0 || d.size() == 0) return "";
	String res = "";
	for (String word: d) {
		if (isSubSeq(s, word)) {
			if (word.length() > res.length()) res = word;
			else if (word.length() == res.length()) {
				int i = 0;
				while (i < res.length() && res.charAt(i) == word.charAt(i)) i++;
				if (i < res.length()) res = (res.charAt(i) > word.charAt(i)) ? word : res;
			}
		}
	}
	return res;
    }  
	
    private boolean isSubSeq(String s, String d) {
	int i = 0;
	for (char c : s.toCharArray()) {
		if (c == d.charAt(i)) {
			i++;
			if (i >= d.length()) return true;
		} 
	}
	return false;
    }

}

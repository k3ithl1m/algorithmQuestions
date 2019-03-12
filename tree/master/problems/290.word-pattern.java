/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (34.55%)
 * Total Accepted:    131.8K
 * Total Submissions: 381.3K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * Example 4:
 * 
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
	HashMap<Character, String> patternMap = new HashMap<>();
	String[] words = str.split(" ");
	if (pattern.length() == 1 && words.length == 1) return true;
	if (pattern.length() != words.length) return false;
	for (int i = 0; i < pattern.length(); i++) {
		char currentChar = pattern.charAt(i);
		if (patternMap.containsValue(words[i]) && !patternMap.containsKey(currentChar)) {
			return false;
		}
		else if (patternMap.containsKey(currentChar)) {
			if (!patternMap.get(currentChar).equals(words[i])) {
				return false;
			}
			else continue;
		} else {
			patternMap.put(currentChar, words[i]);
		}
	}

	return true;
    }
}

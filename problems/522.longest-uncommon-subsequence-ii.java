/*
 * @lc app=leetcode id=522 lang=java
 *
 * [522] Longest Uncommon Subsequence II
 *
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/
 *
 * algorithms
 * Medium (32.70%)
 * Total Accepted:    15K
 * Total Submissions: 46K
 * Testcase Example:  '["aba","cdc","eae"]'
 *
 * 
 * Given a list of strings, you need to find the longest uncommon subsequence
 * among them. The longest uncommon subsequence is defined as the longest
 * subsequence of one of these strings and this subsequence should not be any
 * subsequence of the other strings.
 * 
 * 
 * 
 * A subsequence is a sequence that can be derived from one sequence by
 * deleting some characters without changing the order of the remaining
 * elements. Trivially, any string is a subsequence of itself and an empty
 * string is a subsequence of any string.
 * 
 * 
 * 
 * The input will be a list of strings, and the output needs to be the length
 * of the longest uncommon subsequence. If the longest uncommon subsequence
 * doesn't exist, return -1.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * 
 * 
 * 
 * Note:
 * 
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 * 
 * 
 */
class Solution {
    public int findLUSlength(String[] strs) {
	TreeMap<String, Integer> mapOfStrings = new TreeMap<String, Integer>( new Comparator<String>() {
							@Override
							public int compare(String a, String b) {
								if (b.length() > a.length()) return 1;
								else if (b.length() < a.length()) return -1;
								else return a.compareTo(b);
							}        
						});
	for (int i = 0; i < strs.length; i++) {
		mapOfStrings.put(strs[i], mapOfStrings.getOrDefault(strs[i], 0) + 1);
		System.out.println(strs[i] + " " + mapOfStrings.get(strs[i]));
	}

	for (String key: mapOfStrings.keySet()) {
		System.out.println(key + " " + mapOfStrings.get(key));
		if (mapOfStrings.get(key) < 2) return key.length();
	}
	return -1;
    }
}

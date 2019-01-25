/*
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (54.54%)
 * Total Accepted:    65.5K
 * Total Submissions: 120.2K
 * Testcase Example:  '"abc"'
 *
 * 
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * 
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters. 
 * 
 * 
 * Example 1:
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Note:
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 */
class Solution {
    public int countSubstrings(String s) {
	if (s.length() == 0 || s == null) return 0;
	int count = 0;
	for (int i = 0; i < s.length(); i++) {
		count+= expandCenter(s, i,i);
		count+= expandCenter(s, i, i+1);
	}         
	return count;
    }

	public int expandCenter(String s, int left, int right) {
		int count = 0;
		while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) count++;
		return count;
	}
}

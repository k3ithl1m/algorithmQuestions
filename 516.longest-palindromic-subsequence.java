/*
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (43.52%)
 * Total Accepted:    39.2K
 * Total Submissions: 90.2K
 * Testcase Example:  '"bbbab"'
 *
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * 
 * Example 1:
 * Input: 
 * 
 * "bbbab"
 * 
 * Output: 
 * 
 * 4
 * 
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2:
 * Input:
 * 
 * "cbbd"
 * 
 * Output:
 * 
 * 2
 * 
 * One possible longest palindromic subsequence is "bb".
 * 
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
       	String testString = "";
	int countLongest = countLongest(s, testString, 0);
	int count = countLongest(s, testString, 1);
	
	return Math.max(count, countLongest);	 
    }

	public int countLongest(String s, String testString, int index) {
		if (index >= s.length()) {
			return testString.length();
		}
		testString = testString + s.charAt(index);	
		int count = 0;
		if (isPalindrome(testString)) {
			count = testString.length();	
		}
		int withCount = countLongest(s, testString, index+2);
		int withoutCount = countLongest(s, testString, index+1);
		return Math.max(count, Math.max(withCount, withoutCount));	
	}

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}

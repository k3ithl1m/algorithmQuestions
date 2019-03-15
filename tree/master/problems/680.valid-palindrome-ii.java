/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (33.82%)
 * Total Accepted:    64.3K
 * Total Submissions: 190.1K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */
class Solution {
    public boolean validPalindrome(String s) {
	if (s.length() == 0 || s.length() ==1) return true;
	return checkPalindrome(s);       
    }

    private boolean checkPalindrome(String s) {
	int left = 0, right = s.length() - 1;
	while (left < right) {
		if (s.charAt(left) != s.charAt(right)) {
			return checkPalindrome(s, left + 1, right) || checkPalindrome (s, left, right - 1);
		}
		left++;
		right--;
	}
	return true;
    }

    private boolean checkPalindrome(String s, int left, int right) {
	while (left < right) {
		if (s.charAt(left++) != s.charAt(right--)) return false;
	}
	return true;
    }
}

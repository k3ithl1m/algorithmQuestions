/*
 * [214] Shortest Palindrome
 *
 * https://leetcode.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (26.36%)
 * Total Accepted:    65.1K
 * Total Submissions: 246.8K
 * Testcase Example:  '"aacecaaa"'
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * 
 * 
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcd"
 * Output: "dcbabcd"
 */
class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) return s;
	StringBuilder sb = new StringBuilder();
	int pos = 0;
	for (int i = s.length(); i > 0; i--) {
		System.out.println(i);
		if (checkPalindrome(s.substring(0, i))) {
			sb.append(s.substring(i, s.length()));
			break;
		}
	}
	
	sb.reverse();
	sb.append(s);
	return sb.toString();
	
	
    }

	public boolean checkPalindrome(String s) {
		int left = 0, right = s.length() -1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}

/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.63%)
 * Total Accepted:    365.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
      //handle basecase later
      if (s == null || s.length() <= 1) return s;
      int start = 0, end = 0;
      for (int i = 0; i < s.length() - 1; i++) {
	int len1 = expand(s, i, i);
	int len2 = expand(s, i, i+1);
	int maxNow = Math.max(len1, len2);
	if(maxNow > end - start) {
	  end = i + maxNow/2;
	  start = i - (maxNow -1) /2;
	}
      }        
      return s.substring(start, end +1);
    }

    public int expand(String s, int Left, int Right) {
      while (Left >= 0 && Right < s.length() && s.charAt(Left) == s.charAt(Right)) {
	Left--;
	Right++;
      }
      return Right - Left -1;
    }
}

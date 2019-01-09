/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (24.70%)
 * Total Accepted:    260.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 *
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 *
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 *
 *
 * Example 3:
 *
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Example 4:
 *
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 *
 *
 * Example 5:
 *
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 *
 */
enum Result {
	TRUE, FALSE
}
class Solution {
    Result[][] memo;
    public boolean isMatch(String s, String p) {
	memo = new Result[s.length() + 1][p.length() + 1];
	return checkRegexSP(s,p, 0, 0);
    }

    public boolean checkRegexSP(String s, String p, int posOfS, int posOfP) {
	if (memo[posOfS][posOfP] != null) {
		return memo[posOfS][posOfP] == Result.TRUE;
	}
	boolean ans;
	if (posOfP == p.length()) {
		return ans = posOfS == s.length();
	} else {
		boolean first_match = (posOfS < s.length() && (p.charAt(posOfP) == s.charAt(posOfS)
					|| p.charAt(posOfP) == '.'));
		if (posOfP + 1 < p.length() && p.charAt(posOfP +1) == '*') {
			ans = (checkRegexSP(s,p,posOfS, posOfP + 2) || first_match &&
				checkRegexSP(s,p, posOfS + 1, posOfP));
		} else {
			ans = first_match && checkRegexSP(s,p,posOfS +1 , posOfP +1);
		}
	}
	memo[posOfS][posOfP] = ans ? Result.TRUE : Result.FALSE;
	return ans;
    }
}

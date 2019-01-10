/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (24.70%)
<<<<<<< HEAD
 * Total Accepted:    259.6K
=======
 * Total Accepted:    260.7K
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 * Total Submissions: 1.1M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
<<<<<<< HEAD
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
=======
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
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
<<<<<<< HEAD
 * 
 * 
 * Example 2:
 * 
 * 
=======
 *
 *
 * Example 2:
 *
 *
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
<<<<<<< HEAD
 * 
 * 
 * Example 3:
 * 
 * 
=======
 *
 *
 * Example 3:
 *
 *
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
<<<<<<< HEAD
 * 
 * 
 * Example 4:
 * 
 * 
=======
 *
 *
 * Example 4:
 *
 *
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
<<<<<<< HEAD
 * 
 * 
 * Example 5:
 * 
 * 
=======
 *
 *
 * Example 5:
 *
 *
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
<<<<<<< HEAD
 * 
 * 
=======
 *
 *
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
 */
enum Result {
	TRUE, FALSE
}
class Solution {
    Result[][] memo;
    public boolean isMatch(String s, String p) {
	memo = new Result[s.length() + 1][p.length() + 1];
<<<<<<< HEAD
	return checkRegexSP(s,p, 0, 0);        
=======
	return checkRegexSP(s,p, 0, 0);
>>>>>>> 3b9573a4e348395c9207ccbeea47f9fe3ac2dfb1
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

/*
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.02%)
 * Total Accepted:    203.8K
 * Total Submissions: 969K
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 *
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 *
 * Example 1:
 *
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 *
 * Example 2:
 *
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 *
 */
class Solution {
	public int numDecodings(String s) {
		if (s.isEmpty()) return 1;
		int n = s.length();
		int sn2 = 1;
		int sn1 = s.charAt(n-1) != '0' ? 1 : 0;
		for (int i = n-2; i >= 0; --i) {
			int sn = 0;
			if (s.charAt(i) != '0') {
				sn += sn1;
				if ((s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0') <= 26) sn+=sn2;
			}
			sn2 = sn1;
			sn1 = sn;
		}
		return sn1;
	}

	/**
	 * @param String s, int pos
	 * return int
	 * helper function that recurse through the string
	 * to find the total decoding
	 */
	public int helper(String s, int pos, boolean number) {
		//base case
		if (pos >= s.length()) return 1;
		if (s.charAt(pos) == '0') return 0;
		boolean getSecond = false;
		if ( pos < s.length() -1 ) {

			if (s.charAt(pos) == '2') {
				if (s.charAt(pos+1) < '7') {
					getSecond = true;
				}
			} else if (s.charAt(pos) < '2') {
				getSecond = true;
			}
		}
		return helper(s, pos + 1, true) +
			((getSecond) ? helper(s, pos + 2, true) : 0);

	}
}

/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (44.79%)
 * Total Accepted:    52K
 * Total Submissions: 116.1K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * 
 * 
 * Restrictions: 
 * 
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 * 
 */
class Solution {
    public String reverseStr(String s, int k) {
	if (s == null || s.length() == 0) return s;
	StringBuilder reverseStringBuilder;
	StringBuilder resultStringBuilder = new StringBuilder();
	for (int i = 0; i < s.length(); i = i + 2*k) {
		int maxLength = i + 2*k;
		int reverseLength = i + k;
		reverseStringBuilder = new StringBuilder();
		if (reverseLength < s.length()) {
			reverseStringBuilder.append(s.substring(i, reverseLength));
		} else {
			reverseStringBuilder.append(s.substring(i, s.length()));
		}
		reverseStringBuilder.reverse();
		resultStringBuilder.append(reverseStringBuilder.toString());
		if (reverseLength > s.length()) break;
		else if (maxLength < s.length()) {
			resultStringBuilder.append(s.substring(reverseLength, maxLength));
		} else {
			resultStringBuilder.append(s.substring(reverseLength, s.length()));
		}
	}        
	return resultStringBuilder.toString();
    }
}

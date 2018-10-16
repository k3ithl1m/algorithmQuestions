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
       return helper(s, 0);
    }

    /**
     * @param String s, int pos
     * return int
     * helper function that recurse through the string
     * to find the total decoding
     */
    public int helper(String s, int pos) {
	//base case
	if (pos >= s.length()) return 1;
	if (s.charAt(pos) == '0') return helper(s, pos + 1);
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
	return helper(s, pos + 1) +
		((getSecond) ? helper(s, pos + 2) : 0);
		
    }
}

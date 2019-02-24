/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (25.95%)
 * Total Accepted:    50.4K
 * Total Submissions: 194.1K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */
class Solution {
    public String removeKdigits(String num, int k) {
	if (num == null || num.length() == 0 || num.length() <= k) return "0";  
	StringBuilder sb = new StringBuilder();
	sb.append(num);
	int pointer = 0, charToRemove = k;
	while(pointer < sb.length() && charToRemove > 0) {
		if (pointer == 0 && sb.charAt(pointer) > sb.charAt(pointer+1)) {
			sb.deleteCharAt(pointer);
			charToRemove--;
			continue;
		} else if (pointer != sb.length() - 1 && sb.charAt(pointer) > sb.charAt(pointer + 1)) {
			sb.deleteCharAt(pointer);
			pointer--;
			charToRemove--;
			continue;	
		} else if(pointer == sb.length() -1) {
			sb.deleteCharAt(pointer);
			pointer--;
			charToRemove--;
			continue;
		}
		pointer++;
	}

	int trailingZeroPos = -1;	
	for (int i = 0; i < sb.length(); i++) {
		if (sb.charAt(i) != '0') {
			trailingZeroPos = i;
			break;
		}
	}
	if (trailingZeroPos == -1) return "0";
	return sb.substring(trailingZeroPos);
    }
}

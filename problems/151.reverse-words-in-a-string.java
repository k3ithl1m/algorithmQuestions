/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.71%)
 * Total Accepted:    214.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * Example:  
 * 
 * 
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 */
public class Solution {

    StringBuilder reverser = new StringBuilder();
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();        
 	sb.append(s);
	sb.reverse();
        String[] temp = sb.toString().split(" ");
	sb.delete(0, sb.length());
	for (int i = 0; i < temp.length; i++) {
	    sb.append(reverse(temp[i]));
            if (i != temp.length - 1 && temp[i].length() > 0) {
    	        sb.append(" ");
            }
	}
	return sb.toString();
    }

    public String reverse(String str) {
	reverser.append(str);
	reverser.reverse();
	String temp = reverser.toString();
	reverser.delete(0, str.length());
	return temp;
    }
}


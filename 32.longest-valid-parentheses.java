/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (24.65%)
 * Total Accepted:    166.5K
 * Total Submissions: 674.9K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
	if (s == null || s.length() == 0) return 0;
	Stack<ParenthesesPosition> st1 = new Stack<ParenthesesPosition>();
	Stack<Integer> st = new Stack<Integer>();
	st.push(-1);
	int total = 0;
	for (int i = 0; i < s.length(); i++) {
		char temp = s.charAt(i);	
		if (temp == '(') {
			st.push(i);
		} else {
			st.pop();
			if (st.isEmpty()) st.push(i);
			else total = Math.max(total, i - st.peek());
		}
	}
	return total;
    }
}

class ParenthesesPosition {
	int index;
	boolean openParentheses;
	
	public ParenthesesPosition(int index, boolean open) {
		this.index = index;
		this.openParentheses = open;
	}
}

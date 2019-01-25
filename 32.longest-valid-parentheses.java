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
	Stack<ParenthesesPosition> openParenthesesStack = new Stack<ParenthesesPosition>();
	int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
	int total = 0;
	int validTotal = 0;
	for (int i = 0; i < s.length(); i++) {
		char charAtPos = s.charAt(i);
		ParenthesesPosition temp;
		if (charAtPos == '(') temp = new ParenthesesPosition(i, true);
		else temp = new ParenthesesPosition(i, false);
		if (temp.openParentheses) {
			openParenthesesStack.push(temp);
			continue;
		}
		else {
			//if its empty then it's at the end
			if(!openParenthesesStack.isEmpty()) {
				end  = temp.index;
				start = Math.min(start,openParenthesesStack.pop().index);
				total = Math.max(total, end-start+1);
			} else {
				start = Integer.MAX_VALUE;
			}
		}
	}	
	return (total >= 0) ? total : 0;
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

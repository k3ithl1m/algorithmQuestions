/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (48.87%)
 * Total Accepted:    68.6K
 * Total Submissions: 140.3K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * 
 * 
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * 
 * 
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
	ArrayList<Integer> numberList = new ArrayList<Integer>();	
	ArrayList<Character> operators = new ArrayList<Character>();
	
	int startPos = 0;
	for (int i = 0; i < input.length(); i++) {
		if (!isNumber(input.charAt(i))) {
			numberList.add(Integer.parseInt(input.substring(startPos, i)));
			operators.add(input.charAt(i);
			startPos = i+1;
		}
	}        
	
	numberList.add(Integer.parseInt(input.substring(startPost, input.length())));
	
	ArrayList<Integer> addedVal = new ArrayList<Integer>();
	for (int i = 0; i < operators.size(); i++) {
		if (operators.get(i) == '+') {
			addedVal.add(numberList.get(i) + numberList.get(i+1));
		} else if (operators.get(i) == '-') {
			addedVal.add(numberList.get(i) - numberList.get(i+1));
		} else {
			addedVal.add(numberList.get(i) * numberList.get(i+1));
		}
	}

	ArrayList<Integer> result = new ArrayList<Integer>();
	
    }

    private boolean isNumber(char c) {
	return c <= '9' && c >= '0';
    }
}

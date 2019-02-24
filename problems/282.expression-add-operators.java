/*
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (31.66%)
 * Total Accepted:    59.4K
 * Total Submissions: 187.1K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 */
class Solution {
	// we can break up the string into smaller parts, and go through
	// each of the value, including slowly going through all of it 
	// and call a helper function which tries out all the + - *
	// 
	// base case is when the value is bigger than target, or equal to target,
	// or the length goes over. 
    public List<String> addOperators(String num, int target) {
       	ArrayList<String> ar = new ArrayList<String>();
	helper(ar, num, target, num.charAt(0), 0);	

	return ar;	 
    }

    public void helper(List<String> ar, String num, int target, int current, int start) {
	if (current > target) return;
	if (start >= num.length() && current == target) {
 	}

	for (int i = start; i < num.length(); i++) {
		int temp = Integer.parseInt(start, i);
		if (temp > target) break;
		else helper(ar, num, target, current + temp, i);
	}
    }
}

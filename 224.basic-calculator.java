/*
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (30.74%)
 * Total Accepted:    87.7K
 * Total Submissions: 284.1K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces  .
 * 
 * Example 1:
 * 
 * 
 * Input: "1 + 1"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * 
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
	Stack<Integer> stack = new Stack<>();
	int number = 0;
	int sign = 1;
	int result = 0;
	char chr;

	for (int i = 0; i < s.length(); i++) {
		chr = s.charAt(i);
		if (chr == ' ') continue;
		if (chr >='0' && chr <= '9') {
			number = number * 10 + (int)(chr-'0');
		} else if (chr == '+') {
			result += sign * number;
			number = 0;
			sign = 1;
		} else if (chr == '-') {
			result +=  sign * number;
			number = 0;
			sign = -1;
		} else if (chr == '(') {
			stack.push(result);
			stack.push(sign);
			sign = 1;
			result = 0;
		} else {
			result += sign*number;
			number = 0;
			result *= stack.pop();
			result += stack.pop();
		}
	}

	if (number != 0) {
		result += sign*number;
	}
 	return result;
    }

    public int calculate1(String s) {
	int total = 0;
	Stack<Integer> numSt = new Stack<Integer>();
	Stack<Character> charSt = new Stack<Character>();

	for (int i = 0; i < s.length(); i++) {
		char temp = s.charAt(i);
		// If temp is equals to numbers, then we find all the numbers and push it into the stack
				System.out.println(temp);
		if (Character.getNumericValue(temp) != -1) {
			int j = i;
			while (j < s.length() && Character.getNumericValue(s.charAt(j)) != -1) {
				j++;
			}
			int tempNum = Integer.parseInt(s.substring(i, j));
			numSt.push(tempNum);
			
			i = j - 1;
			// we should do the calculations here.
			if (!charSt.isEmpty()) {
				char symbol = charSt.pop();
				if (symbol == '(') {
					charSt.push(symbol);
					continue;
				} else {

					int secNum = numSt.pop();
					int firstNum = numSt.pop();
					if (symbol == '+') {
						firstNum = firstNum + secNum;
					} else if (symbol == '-') {
						firstNum = firstNum - secNum;
					} else if (symbol == '*') {
						firstNum = firstNum * secNum;
					} else if (symbol == '/') {
						firstNum = firstNum / secNum;
					}
					
					numSt.push(firstNum);
				}
			}
		}

		if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
			charSt.push(temp);
		}
		
		if (temp == '(') {
			charSt.push(temp);
			continue;
		}

		if (temp == ')') {
			char newTemp =  charSt.pop();
			if (newTemp == '(' && !charSt.isEmpty()) {
				char symbol = charSt.pop();
				
				if (symbol == '(') {
					charSt.push(symbol);
					continue;
				} else  {
					int secNum = numSt.pop();
					int firstNum = numSt.pop();
					if (symbol == '+') {
						firstNum = firstNum + secNum;
					} else if (symbol == '-') {
						firstNum = firstNum - secNum;
					} else if (symbol == '*') {
						firstNum = firstNum * secNum;
					} else if (symbol == '/') {
						firstNum = firstNum / secNum;
					}
					
					numSt.push(firstNum);
				}
			}	
		}
	}        
	
	return numSt.pop();
    }
}

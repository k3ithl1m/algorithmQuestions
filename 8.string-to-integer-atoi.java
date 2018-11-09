/*
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (14.19%)
 * Total Accepted:    284.6K
 * Total Submissions: 2M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "42"
 * Output: 42
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical 
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * 
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−231) is returned.
 * 
 */
class Solution {
    // Convert everything to a char array so that we can go through it
    // - Go through the array and see if it's whitespace
    // ## if Whitespace, move to next char
    // ## if - or +, add it to stringbuilder
    // ## if its numbers, add it to stringbuilder
    // ## else return 0
    // Go through the numbers until it isnt numbers.
    // - try ParseInt with Catch. Return String.parseInt(Stringbuilder)
    // - else catch and send overflow based on the first character,
    // if it is -, return Integer.MIN_VALUE, if positive, return MAX_VALUE
    public int KeithNoobAtoi(String str) {
	if (str.length() == 0 || str == null) return 0;
	if (str.length() == 1 && !(str.charAt(0) >= '0' && str.charAt(0) <='9')) return 0;
	char[] cAr = str.toCharArray();
      	StringBuilder sb = new StringBuilder();
	int pos = 0;
	for (char c: cAr) {
		pos++;
		if (c == ' ') continue;
		else if (c == '+' || c == '-') {
			sb.append(c);
			break;
		}
		else if (!(c >= '0' && c <= '9')) return 0;
		else {
			pos--;
			break;
		}
	}

	if (pos < cAr.length) {
		char val = cAr[pos];
		if (!(val>='0' && val<= '9')) return 0;
		while (pos < cAr.length) {
			val = cAr[pos];
			if (val >='0' && val<='9') {
				System.out.println(val);
				sb.append(val);
			}else break;
			pos++;
		}
	} else {
		return 0;
	}
	
	String s = sb.toString();

	try {
		return Integer.parseInt(s);
	} catch(Exception err){
		if (s.charAt(0) == '-') return Integer.MIN_VALUE;
		else return Integer.MAX_VALUE;
	}
    }

    public int myAtoi(String str) {
	int index = 0, sign = 1, total = 0;
	//1. Empty String
	if(str.length() == 0) return 0;

	// 2.Remove Spaces
	while(index < str.length() && str.charAt(index) == ' ') index++;

	// 3.Handle Signs
	if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
		sign = str.charAt(index) == '+' ? 1 : -1;
		index++;
	}

	// 4. handle no numbers
	if (index < str.length() && !Character.isDigit(str.charAt(index))) return 0;

	// 5. Convert number and avoid overflow
	int result = 0;
	while (index < str.length()) {
		if(!Character.isDigit(str.charAt(index))) break;
		char current = str.charAt(index++);
		int previous = result;
		result *= 10;

		//check if total will overflow after 10 times and add digit
		if(previous != result/10) {
			return sign == -1 ?Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		result += (current -'0');
		if (result < 0) {
			return sign==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
		}
	}
	return result * sign;
    }
}

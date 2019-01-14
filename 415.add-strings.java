/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms * Easy (42.36%)
 * Total Accepted:    77.8K
 * Total Submissions: 183K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
	if (num1 == null || num1.length() == 0) return num2;
	if (num2 == null || num2.length() == 0) return num2;
	if (num1.length() < num2.length()) {
		String temp = num2;
		num2 = num1;
		num1 = temp;
	}        
	
	StringBuilder finalResult = new StringBuilder();
//	boolean overflow = false;
//	int diff = num1.length() - num2.length();
//	for (int i = num1.length()-1; i >= 0; i--) {
//		int j = i - diff;
//		if (j >= 0) {
//			int currentValue = num1.charAt(i) + num2.charAt(j) - '0' - '0';
//			if (overflow) {
//				currentValue++;
//				overflow = false;
//			}
//			if (currentValue / 10 >= 1) {
//				overflow = true;
//			}
//			System.out.println(currentValue);
//			finalResult.append(currentValue%10);
//		} else {
//			if (overflow) {
//				overflow = false;
//				int currentValue = num1.charAt(i)-'0' + 1;
//				if (currentValue / 10 >= 1) overflow = true;
//				finalResult.append(currentValue%10);
//			} else finalResult.append(num1.charAt(i));
//		}
//	}
//	if (overflow) finalResult.append('1');
	int i = num1.length() -1;
	int j = num2.length() -1;
	int carry = 0;
	while(i>=0 || j >= 0 || carry == 1) {
		int x = i < 0 ? 0: num1.charAt(i) - '0';
		int y = j < 0 ? 0: num2.charAt(j) - '0';
		finalResult.append((x+y+carry) % 10);
		carry = (x+y+carry) / 10;
		i--;
		j--;
	}
	return finalResult.reverse().toString();
    }
}

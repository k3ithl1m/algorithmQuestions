/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (23.82%)
 * Total Accepted:    91.5K
 * Total Submissions: 383.9K
 * Testcase Example:  '123'
 *
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * 
 * 
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty
 * Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 */
class Solution {
	String[] UNDER_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
		"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
		"Eighteen", "Nineteen"};
	String[] TENS = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety"};
	String[] UP_VALUES = new String[]{"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
	if (num == 0) return "Zero";
	
	String resultString = "";
	int i=0;
        while(num > 0) {
		if (num %1000 != 0) {
			resultString = helper(num%1000).trim() + " " + UP_VALUES[i] + " " + resultString;
		}
		num /=1000;
		i++;
	}

	return resultString.trim();
    }

    private String helper(int num) {
	if (num < 20) {
		return UNDER_20[num] ;
	} else if (num < 100) {
		return TENS[num/10] + " " + helper(num%10);
	} else {
		return UNDER_20[num/100] + " Hundred " + helper(num%100);
	}
    }
}

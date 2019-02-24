/*
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (49.97%)
 * Total Accepted:    305.7K
 * Total Submissions: 611.7K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
class Solution {
    
    // The first thing to do is to put the values into the hashmap for easy access
    // - the first subproblem is to go through each alphabets and get the value
    // from the hashmap to add it all together.
    // for (char) total = total + hm.get(char);
    // - We then have to consider the ones where there is a smaller value before it
    // - if we keep two pointers? always comparing the current one with the next one.
    // p1 = 0, p2 = 1;
    // if (hm.get(charAt[p2]) > hm.get(charAt[p1]) 
    //     total = total + valAtp2 - valAtp1;
    //     p1=p2+1, p2=p2+2;
    // We have to have it till the end, and after we finish the loop, we've to add the
    // last one because we would have to break out of it when p2 > the string length
    //
    // Solution 
    // 	    char[] cAr = s.toCharArray();
    // 	    int p1 = 0, p2 = 1, total =0;
    // 	    while(p2 < cAr.length) 
    // 	    	valp1 = hm.get(cAr[p1];
    // 	    	valp2 = hm.get(cAr[p2];
    // 	    	if (valp2 > valp1)
    // 	    	    total = total + valp2 - valp1;
    // 	    	    p1++;
    // 	    	    p2++;
    // 	    	else
    // 	    	    total += valp1
    // 	    	p1++;
    // 	    	p2++;
    // 	    if (p1 <= cAr.length) total += hm.get(cAr[p1]);
    // 	    return total
    public int romanToInt(String s) {
	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	hm.put('I', 1);
	hm.put('V', 5);
	hm.put('L', 50);
	hm.put('X', 10);
	hm.put('C', 100);
	hm.put('D', 500);
	hm.put('M', 1000);
	char[] cAr = s.toCharArray();
	int p1 = 0, p2 = 1, total = 0;
	while (p2 < cAr.length) {
		int valp1=hm.get(cAr[p1]);
		int valp2=hm.get(cAr[p2]);
		if (valp2 > valp1) {
			total = total + valp2 - valp1;
			p1++;
			p2++;
		} else total += valp1;
		p1++;
		p2++;
	}
	if (p1< cAr.length) total += hm.get(cAr[p1]);
	return total;
    }
} 

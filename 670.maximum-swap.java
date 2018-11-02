/*
 * [670] Maximum Swap
 *
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * algorithms
 * Medium (38.84%)
 * Total Accepted:    29.2K
 * Total Submissions: 75K
 * Testcase Example:  '2736'
 *
 * 
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * 
 * Example 1:
 * 
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The given number is in the range [0, 108]
 * 
 * 
 */
class Solution {
    public int maximumSwap(int num) {
	String str = String.valueOf(num);
	boolean switched = false;
	int max = num;
	for (int i = 0; i < str.length(); i++) {
	    for (int j = i+1; j < str.length(); j++) {
		int ipos = Character.getNumericValue(str.charAt(i));
		int jpos = Character.getNumericValue(str.charAt(j));
		if (ipos < jpos) {
		    int temp = num;
		    System.out.println(ipos + " " + jpos + " " + str + " " + i
				    + " " + j);
		    temp = temp - (int) Math.pow(10, str.length() -1 - i) * ipos
			    + (int) Math.pow(10, str.length() -1 - i) * jpos
			    - (int) Math.pow(10, str.length() -1 - j) * jpos
			    + (int) Math.pow(10, str.length() -1 - j) * ipos;
		    switched = true;
		    if (temp > max) max = temp;
		}
	    }
	    if (switched) break;
	}
	return max;
    }
}

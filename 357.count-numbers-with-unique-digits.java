/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (46.43%)
 * Total Accepted:    56.9K
 * Total Submissions: 122.5K
 * Testcase Example:  '2'
 *
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 * 
 * 
 * Example:
 * 
 * 
 * Input: 2
 * Output: 91 
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x <
 * 100, 
 * excluding 11,22,33,44,55,66,77,88,99
 * 
 * 
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
	if (n == 0) return 1;
	ArrayList<Integer> result = new ArrayList<Integer>();
	int count = 0;
	return helper(n, 0, count, result);        
    }
 
    public int helper(int n, int pos, int count, ArrayList<Integer> result) {
	if (!result.isEmpty()) {
		count++;
	}
	if (pos > n) return count;

	for (int i = 0; i < n; i++) {
		if (pos == 0 && i == 0) {
			helper(n, pos + 1, count, result);
			continue;
		} else {
			if(result.contains(i)) continue;
			result.add(i);
			helper(n, pos + 1, count, result);
			result.remove(result.size() -1);
		}
	}
	return count;
    }
}

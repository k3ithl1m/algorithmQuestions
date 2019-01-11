/*
 * @lc app=leetcode id=686 lang=java
 *
 * [686] Repeated String Match
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (31.28%)
 * Total Accepted:    55.1K
 * Total Submissions: 176.1K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note:
 * The length of A and B will be between 1 and 10000.
 * 
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
	int count = 0;
	StringBuilder sb = new StringBuilder();
	while(sb.length() < B.length()) {
		sb.append(A);
		count++;
	}
	if (sb.toString().contains(B)) return count;
<<<<<<< HEAD
	if (sb.append(A).toString().contains(B)) return count++;
=======
	if (sb.append(A).toString().contains(B)) return ++count;
>>>>>>> b1b1ccdc2cefd7d88f143eabd923b8f892d2be68
	return -1;
    }
}

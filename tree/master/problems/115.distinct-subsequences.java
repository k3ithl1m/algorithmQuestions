/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 *
 * https://leetcode.com/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (34.47%)
 * Total Accepted:    100.6K
 * Total Submissions: 291.6K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * Given a string S and a string T, count the number of distinct subsequences
 * of S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Example 1:
 * 
 * 
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * 
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * 
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * 
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * 
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *  ⁠ ^  ^^
 * babgbag
 *  ⁠   ^^^
 * 
 * 
 */
class Solution {
    public int numDistinct(String s, String t) {
	if (s.length() == 0) return 0;
	int[][] storeCount = new int[s.length()+1][t.length()+1];
	for (int i = 0; i <= s.length(); i++) Arrays.fill(storeCount[i],-1);
	backtrack(s, t, 0, 0, storeCount);
	return storeCount[0][0];
    }

    private int backtrack(String s, String t, int sStart, int tStart, int[][] mem) {
	if (mem[sStart][tStart] != -1) return mem[sStart][tStart];
	//if t is longer than s
	if (sStart == s.length() && tStart < t.length()) return mem[sStart][tStart] = 0;
	//if reach the end of t
	if (tStart == t.length()) return mem[sStart][tStart] = 1;
	if (s.charAt(sStart) == t.charAt(tStart)) {
		return mem[sStart][tStart] = backtrack(s, t, sStart + 1, tStart, mem) + 
					backtrack(s, t, sStart+1, tStart + 1, mem);
	}
	else return mem[sStart][tStart] = backtrack(s, t, sStart + 1, tStart, mem);
    }

    private void backtrack2(String s, String t, int sPos, int tPos, int[] storeCount) {
	if (sPos > s.length()) return;
	if (tPos >= t.length()) {
		storeCount[0]++;
		return;
	}
	if (t.length() - tPos > s.length() - sPos) return;
	for (int i = sPos; i < s.length(); i++) {
		if (s.charAt(i) == t.charAt(tPos)) {
			backtrack2(s, t, i+1, tPos+1, storeCount);
		}
	}
    }
}

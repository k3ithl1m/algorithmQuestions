/*
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (37.98%)
 * Total Accepted:    139.1K
 * Total Submissions: 366.3K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        //Base case needed
	if (s.length() == 0) return new ArrayList<List<String>>();
	ArrayList<List<String>> ls  = new ArrayList<List<String>>();
	ArrayList<String> l = new ArrayList<String>();
	helper(s, 0, l, ls);
	return ls;
    }

    public void helper(String s, int start, List<String> l, List<List<String>> ls) {
	
	if (start >= s.length()) {
		ls.add(new ArrayList<>(l));
		return;
	}
	for (int i = 1; i < s.length() + 1 - start; i++) {
		String temp = s.substring(start, i + start);
		if (checkPalindrome(temp)) l.add(temp);
		else continue;
		System.out.println(temp + " " + l.size());
		helper(s, i+start, l, ls);
		l.remove(l.size() - 1);
	}
    }

    public boolean checkPalindrome(String s) {
	int left = 0, right = s.length() -1;
	while(left < right) {
		if (s.charAt(left) != s.charAt(right)) return false;
		left++;
		right--;
	}
	return true;
    }
}

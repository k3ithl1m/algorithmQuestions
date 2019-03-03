/*
 * @lc app=leetcode id=466 lang=java
 *
 * [466] Count The Repetitions
 *
 * https://leetcode.com/problems/count-the-repetitions/description/
 *
 * algorithms
 * Hard (27.35%)
 * Total Accepted:    7.3K
 * Total Submissions: 26.7K
 * Testcase Example:  '"acb"\n4\n"ab"\n2'
 *
 * Define S = [s,n] as the string S which consists of n connected strings s.
 * For example, ["abc", 3] ="abcabcabc". 
 * On the other hand, we define that string s1 can be obtained from string s2
 * if we can remove some characters from s2 such that it becomes s1. For
 * example, “abc”  can be obtained from “abdbec” based on our definition, but
 * it can not be obtained from “acbbe”.
 * You are given two non-empty strings s1 and s2 (each at most 100 characters
 * long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the
 * strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer
 * M such that [S2,M] can be obtained from S1.
 * 
 * Example:
 * 
 * Input:
 * s1="acb", n1=4
 * s2="ab", n2=2
 * 
 * Return:
 * 2
 * 
 * 
 */
class Solution {
    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
	String firstString = "";
	String secondString = "";
	if (s1.length() == 0 || n1 == 0) return 0;
	if (s1.equals(s2)) return n1/n2;
	for (int i = 0; i < n1; i++) {
		firstString +=s1;
	}
	for (int i = 0; i < n2; i++) {
		secondString +=s2;
	}
	
	int count=0;;
	int secondPos = 0;
	for (int i = 0; i < firstString.length(); i++) {
		char currentChar = firstString.charAt(i);
		if (currentChar == secondString.charAt(secondPos)) {
			secondPos++;
		}
		if (secondPos == secondString.length()) {
			count++;
			secondPos = 0;
		}
	}
	return count;
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
	String firstString = "";
	String secondString = "";
	if (s1.length() == 0 || n1 == 0) return 0;
	if (s1.equals(s2)) return n1/n2;
	int s2Pos = 0;
	int s1Pos = 0;
	int s1Count = 0;
	while (s2Pos < s2.length()) {
		if (s1Pos == 0) s1Count++;
		if (s1.charAt(s1Pos) == s2.charAt(s2Pos++)) {}
		s1Pos++;
		if (s1Pos == s1.length()) {
			s1Pos=0;
		}
	}
	
	return (n1/s1Count) / n2;
	
    }
}

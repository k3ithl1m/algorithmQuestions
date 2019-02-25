/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (37.63%)
 * Total Accepted:    39.5K
 * Total Submissions: 105K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * Example 1:
 * 
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * 
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
       	int[] charMap = new int[256];
	for (char c: s1.toCharArray()) {
		charMap[c]++;
	}

	int length = s1.length(), leftPointer = 0, rightPointer = 0;
	while(rightPointer < s2.length()) {
		char currentChar = s2.charAt(rightPointer++);
		charMap[currentChar]--;
		if (charMap[currentChar] >= 0) length--;
		else {
			char incrementChar = s2.charAt(leftPointer);
			while (charMap[incrementChar] < 0) {
				charMap[incrementChar]++;
				if (charMap[incrementChar] >= 0) length++;
				if (++leftPointer >= s2.length()) return false;
				incrementChar = s2.charAt(leftPointer);
			}
		}
		if (length <= 0) return true;
		
	}
	return false;
    }
}

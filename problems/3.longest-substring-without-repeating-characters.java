/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (24.93%)
 * Total Accepted:    557.6K
 * Total Submissions: 2.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", which the length is 3.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
      int left = 0, right = 0, max = 0, count = 0;
      int[] hm = new int[256];

      while (right < s.length()) {
	char c = s.charAt(right);
	hm[c]++;
	count++;
	while(hm[c] > 1) {
	  char c2 = s.charAt(left);
	  hm[c2]--;
	  left++;
	  count--;
	}
	
	max = Math.max(max, count);
	right++;
      }        
      return max;
    }
}

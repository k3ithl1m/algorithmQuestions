/*
 * [316] Remove Duplicate Letters
 *
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Hard (31.35%)
 * Total Accepted:    49.5K
 * Total Submissions: 157.4K
 * Testcase Example:  '"bcabc"'
 *
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * 
 * Input: "bcabc"
 * Output: "abc"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbacdcbc"
 * Output: "acdb"
 * 
 */
class Solution {
    public String removeDuplicateLetters(String sr) {
	int[] res = new int[26];
	boolean[] visited = new boolean[26];
	char[] ch = sr.toCharArray();
	for (char c: ch) res[c-'a']++;
	Stack<Character> st = new Stack<>();
	int index;
	for (char s: ch) {
		index = s - 'a';
		res[index]--;
		if (visited[index]) continue;
		while (!st.isEmpty() && s < st.peek() && res[st.peek() - 'a'] != 0) visited[st.pop()-'a'] = false;
		st.push(s);
		visited[index] = true;
	}
	StringBuilder sb = new StringBuilder();
	while(!st.isEmpty()) sb.insert(0,st.pop());
	return sb.toString();        
    }
}

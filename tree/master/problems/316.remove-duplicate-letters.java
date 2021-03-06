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
    public String removeDuplicateLetters(String s) {
	int[] map = new int[26];
	boolean[] visited = new boolean[26];
	char[] charArray = s.toCharArray();
	for (char c : charArray) map[c-'a']++;
	Deque<Character> charQueue = new LinkedList<>();
	for (char c : charArray) {
		map[c-'a']--;
		if (visited[c-'a']) continue;
		while(!charQueue.isEmpty() && c < charQueue.peek() 
			&& map[charQueue.peek()-'a']!=0) {
			visited[charQueue.pop() -'a'] = false;
		}
		charQueue.push(c);
		visited[c-'a'] = true;
 	}
	StringBuilder sb = new StringBuilder();
	while (!charQueue.isEmpty()) sb.append(charQueue.removeLast());
	return sb.toString();
    }

    public String removeDuplicateLetters2(String s) {
	int[] letterMap = new int[26];
	boolean[] visited = new boolean[26];
	for (int i = 0; i < s.length(); i++) letterMap[s.charAt(i) - 'a']++;
	Stack<Character> charStack = new Stack<>();
	int index;
	for (char c : s.toCharArray()) {
		index = c - 'a';
		letterMap[c-'a']--;
		if (visited[index]) continue;
		while(!charStack.isEmpty() && c < charStack.peek() && 
			letterMap[charStack.peek()-'a'] != 0) {
			visited[charStack.pop() -'a'] = false;
		}
		charStack.push(c);
		System.out.println(charStack.peek());
		visited[c-'a'] = true;
	}        

	StringBuilder sb = new StringBuilder();
	while (!charStack.isEmpty()) sb.insert(0, charStack.pop());
	return sb.toString();
    }
}

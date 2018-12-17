/*
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (28.88%)
 * Total Accepted:    54.7K
 * Total Submissions: 189K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
       	TrieNode head = new TrieNode();
	for (int j = 0; j < words.length; j++) {
		String word = words[j];
		TrieNode temp = head;
		for (int i = word.length() - 1; i >= 0; i--){
			char c = word.charAt(i);
			if (isPalindrome(word, 0, i)) {
				temp.list.add(i);
			}
			boolean st = temp.setNode(c);
			temp=temp.getNode(c);
		}
		temp.end = true;
		temp.val = word;
		temp.pos = j;
	}

	List<List<Integer>> results = new ArrayList<>();
	for (int j = 0; j < words.length; j++) {
		String word = words[j];	
		TrieNode root = head;
		for (int i = 0; i < word.length(); i++) {
			if (root.end && root.pos != j && isPalindrome(word, i, word.length() - 1)) {
				System.out.println(word.charAt(i));
				results.add(Arrays.asList(j, root.pos));
			}
			
			root = root.getNode(word.charAt(i));
			if (root == null) {
				break;	
			}
		}
		if (root == null) continue;

		for (int k : root.list) {
			if (k == j) continue;
			results.add(Arrays.asList(j, k));
		}
	}
	return results;
    }

    public boolean isPalindrome(String word, int i, int j) {
	while (i < j) {
		if (word.charAt(i++) != word.charAt(j--)) return false;
	}
	return true;
    }
}

class TrieNode {
	String val;
	int pos;
	boolean end;
	List<Integer> list;
	TrieNode[] tn;
	public TrieNode() {
		this.tn = new TrieNode[26];
		this.end = false;
		list = new ArrayList<>();
	}

	public TrieNode getNode(char c) {
		return tn[c-'a'];
	}

	public boolean setNode(char c) {
		if (tn[c-'a']==null) {
			tn[c-'a'] = new TrieNode();
			return true;
		} else return false;
	}
}

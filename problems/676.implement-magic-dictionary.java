/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 *
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 *
 * algorithms
 * Medium (50.80%)
 * Total Accepted:    22K
 * Total Submissions: 43.3K
 * Testcase Example:  '["MagicDictionary", "buildDict", "search", "search", "search", "search"]\n[[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]'
 *
 * 
 * Implement a magic directory with buildDict, and search methods.
 * 
 * 
 * 
 * For the method buildDict, you'll be given a list of non-repetitive words to
 * build a dictionary.
 * 
 * 
 * 
 * For the method search, you'll be given a word, and judge whether if you
 * modify exactly one character into another character in this word, the
 * modified word is in the dictionary you just built.
 * 
 * 
 * Example 1:
 * 
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by now. You could think
 * about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class
 * MagicDictionary, as static/class variables are persisted across multiple
 * test cases. Please see here for more details.
 * 
 * 
 */
class MagicDictionary {
	HashSet<String> wordDict;
    /** Initialize your data structure here. */
    public MagicDictionary() {
       	wordDict = new HashSet<String>(); 
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
       	for (int i = 0; i < dict.length; i++) {
		wordDict.add(dict[i]);
	} 
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
	StringBuilder sb = new StringBuilder();
	sb.append(word);
	int count = 0;
	for (int i = 0; i < word.length(); i++) {
		char storeChar = sb.charAt(i);
		for (char c = 'a'; c <= 'z'; c++) {
			if (c == storeChar) continue;
			sb.setCharAt(i, c);
			if (wordDict.contains(sb.toString())) {
				return true;
			} 	
		}
		sb.setCharAt(i, storeChar);
	} 
	return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

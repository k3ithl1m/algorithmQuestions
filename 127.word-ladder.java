/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (20.83%)
 * Total Accepted:    188.6K
 * Total Submissions: 896.1K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	HashSet<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
	HashSet<String> visited = new HashSet<String>();
	Set<String> dictSet = new HashSet<>(wordList);
	int len = 1;
	beginSet.add(beginWord);
	if (!dictSet.contains(endWord)) return 0;
	endSet.add(endWord);

	while(!beginSet.isEmpty() && !endSet.isEmpty()) {
	    if (beginSet.size() > endSet.size()) {
		HashSet<String> set = beginSet;
		beginSet = endSet;
		endSet = set;
	    }
	    HashSet<String> temp = new HashSet<String>();	    
	    for (String word: beginSet) {
		char[] cAr = word.toCharArray();
		for (int i = 0; i < cAr.length; i++) {
		    for (char c = 'a'; c <= 'z'; c++) {
			char old = cAr[i];
			cAr[i] = c;
			String newWord = String.valueOf(cAr);
			
			// first we have to check if it;'s in the other list
			if (endSet.contains(newWord)) {
			    return len + 1;
			}

			//here we have to check if it's in the list
			if (!visited.contains(newWord) && dictSet.contains(newWord)) {
			    visited.add(newWord);
			    temp.add(newWord);
			}
			
			cAr[i] = old;
		    }
		}
	    }
      	len++;
	//We have to replace the old begin list with a new one. 
	beginSet = temp;
	}        
	return 0;
    }
}

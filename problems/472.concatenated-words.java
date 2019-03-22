/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 *
 * https://leetcode.com/problems/concatenated-words/description/
 *
 * algorithms
 * Hard (33.57%)
 * Total Accepted:    18.9K
 * Total Submissions: 56.2K
 * Testcase Example:  '["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]'
 *
 * Given a list of words (without duplicates), please write a program that
 * returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words in the given array.
 * 
 * Example:
 * 
 * Input:
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; "ratcatdogcat"
 * can be concatenated by "rat", "cat", "dog" and "cat".
 * 
 * 
 * 
 * Note:
 * 
 * The number of elements of the given array will not exceed 10,000 
 * The length sum of elements in the given array will not exceed 600,000. 
 * All the input string will only include lower case letters.
 * The returned elements order does not matter. 
 * 
 * 
 */
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
	ArrayList<String> resultList = new ArrayList<>();
	if (words.length == 0) return resultList;
        HashSet<String> map = new HashSet<>();
	Arrays.sort(words, new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	});

	for (int i = 0; i < words.length; i++) {
		if (checkWord(words[i], map)) resultList.add(words[i]);
		map.add(words[i]);
	}
	return resultList;
    }

    private boolean checkWord(String word, HashSet<String> map) {
	if (word.length() == 0) return false;
	boolean[] cache = new boolean[word.length() + 1];
	cache[0] = true;
	for (int i = 0; i <= word.length(); i++) {
		for (int j = 0; j < i; j++) {
			if (cache[j] && map.contains(word.substring(j, i))) {
				cache[i] = true;
				break;
			}
		}
	}

	return cache[word.length()];
    }
}

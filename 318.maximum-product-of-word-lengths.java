/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (47.51%)
 * Total Accepted:    74.2K
 * Total Submissions: 156.2K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1:
 * 
 * 
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16 
 * Explanation: The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * 
 * 
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4 
 * Explanation: The two words can be "ab", "cd".
 * 
 * Example 3:
 * 
 * 
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0 
 * Explanation: No such pair of words.
 * 
 */
class Solution {
    public int maxProduct2(String[] words) {
	ArrayList<HashSet<Character>> hashsetArrays = new ArrayList<>();
	for (String word: words) {
		HashSet<Character> hashsetStore = new HashSet<>();
		for (char c: word.toCharArray()) hashsetStore.add(c);
		hashsetArrays.add(hashsetStore);
	}        
	int maxValue = 0;
	for (int i = 0; i < hashsetArrays.size(); i++) {
		HashSet<Character> mainSet = hashsetArrays.get(i);
		for (int j = i + 1; j < hashsetArrays.size(); j++) {
			HashSet<Character> compareSet = hashsetArrays.get(j);
			boolean foundSame = false;
			Iterator it = mainSet.iterator();
			while (it.hasNext()) {
				char c = (char) it.next();
				if (compareSet.contains(c)) {
					foundSame = true;
					break;
				}
			}
			if (!foundSame) maxValue = Math.max(maxValue, words[i].length() * words[j].length());
		}
	}

	return maxValue;
    }

    public int maxProduct(String[] words) {
	int[] value = new int[words.length];
	for (int i = 0; i < words.length; i++) {
		String word = words[i];
		for (char c: word.toCharArray()) value[i] |= 1 << (c-'a');
	}        
	int maxValue = 0;
	for (int k = 0; k < value.length; k++) {
		for (int j = k + 1; j < value.length; j++) {
			if ((value[k] & value[j]) == 0) {
				maxValue = Math.max(maxValue, words[k].length() * words[j].length());
			}
		}
	}

	return maxValue;
    }
}

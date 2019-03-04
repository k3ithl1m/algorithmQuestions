/*
 * @lc app=leetcode id=691 lang=java
 *
 * [691] Stickers to Spell Word
 *
 * https://leetcode.com/problems/stickers-to-spell-word/description/
 *
 * algorithms
 * Hard (37.43%)
 * Total Accepted:    7.3K
 * Total Submissions: 19.6K
 * Testcase Example:  '["with","example","science"]\n"thehat"'
 *
 * 
 * We are given N different types of stickers.  Each sticker has a lowercase
 * English word on it.
 * 
 * You would like to spell out the given target string by cutting individual
 * letters from your collection of stickers and rearranging them.
 * 
 * You can use each sticker more than once if you want, and you have infinite
 * quantities of each sticker.
 * 
 * What is the minimum number of stickers that you need to spell out the
 * target?  If the task is impossible, return -1.
 * 
 * 
 * Example 1:
 * Input:
 * ["with", "example", "science"], "thehat"
 * 
 * 
 * Output:
 * 3
 * 
 * 
 * Explanation:
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the
 * target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target
 * string.
 * 
 * 
 * Example 2:
 * Input:
 * ["notice", "possible"], "basicbasic"
 * 
 * 
 * Output:
 * -1
 * 
 * 
 * Explanation:
 * We can't form the target "basicbasic" from cutting letters from the given
 * stickers.
 * 
 * 
 * Note:
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English
 * letters.
 * In all test cases, all words were chosen randomly from the 1000 most common
 * US English words, and the target was chosen as a concatenation of two random
 * words.
 * The time limit may be more challenging than usual.  It is expected that a 50
 * sticker test case can be solved within 35ms on average.
 * 
 */
class Solution {
    public int minStickers(String[] stickers, String target) {
	if (stickers.length == 0) return -1;
	if (target.length() == 0) return 0;
	ArrayList<HashMap<Character, Integer>> wordsToMap = new ArrayList<>();
	for (int i = 0; i < stickers.length; i++) {
		String str = stickers[i];
		HashMap<Character, Integer> currentMap = new HashMap<>();
		for (char c: str.toCharArray()) {
			currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
		}
		wordsToMap.add(i,currentMap);
	}
	//We've put every words in a hashmap. Now we just have to put the found word into a 
	//arraymap. I think a map with [128] char is good
	int[] wordMap = new int[128];
	int[] cache = new int[stickers.length];
	Arrays.fill(cache, Integer.MAX_VALUE);
	for (char c : target.toCharArray()) {
		wordMap[c]++;
	}
	int targetLength = target.length();
	int countMin = backtrackHelper(wordsToMap, wordMap, targetLength, 0,0, cache);
	return (countMin == Integer.MAX_VALUE) ? -1 : countMin;
    }

    private int backtrackHelper(ArrayList<HashMap<Character, Integer>> wordsToMap, int[] wordMap,
		int targetLength, int count, int pos, int[] cache) {
	if (targetLength <= 0) return count;
	if (pos >= wordsToMap.size()) return Integer.MAX_VALUE;
	if (cache[pos] != Integer.MAX_VALUE) return cache[pos]; 
	int countMin = Integer.MAX_VALUE;
	int lengthLeft = targetLength;
	for (int j = pos; j < wordsToMap.size(); j++) {
		HashMap<Character, Integer> charToIntMap = wordsToMap.get(j);
		for (char c: charToIntMap.keySet()) {
			int charCount = charToIntMap.get(c);
			for (int i = 0; i < charCount; i++) {
				if (wordMap[c]-- > 0) {
					lengthLeft--;
				}
			}
		}
		// Go in only if stickers are used
		if (lengthLeft < targetLength) {
			countMin = Math.min(countMin, Math.min(
				backtrackHelper(wordsToMap, wordMap, lengthLeft, count+1, j, cache),
				backtrackHelper(wordsToMap, wordMap, lengthLeft, count+1, j, cache)));
		}

		for (char c: charToIntMap.keySet()) {
			int charCount = charToIntMap.get(c);
			for (int i = 0; i < charCount; i++) {
				if (++wordMap[c] > 0) lengthLeft++;
			}
		}
	}
	cache[pos] = countMin;
	return countMin;
    }
}

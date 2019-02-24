/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (54.50%)
 * Total Accepted:    80.3K
 * Total Submissions: 147.1K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */
class Solution {
    public String frequencySort(String s) {
	if (s.length() <= 1) return s;
	HashMap<Character, Integer> countCharMap = new HashMap<>();
	for (Character c : s.toCharArray()) {
		countCharMap.put(c, countCharMap.getOrDefault(c, 0) + 1);
	}        
	PriorityQueue<CharCount> charCountHeap = new PriorityQueue<CharCount>(new Comparator<CharCount>() {
				public int compare(CharCount a, CharCount b) {
					return b.count - a.count;
				}
			});
	for (Character c: countCharMap.keySet()) {
		CharCount currentCharCount = new CharCount(countCharMap.get(c), c);
		charCountHeap.add(currentCharCount);
	}
	StringBuilder resultBuilder = new StringBuilder();
	while (!charCountHeap.isEmpty()) {
		CharCount appendCharCount = charCountHeap.remove();
		for (int i = 0; i < appendCharCount.count; i++) {
			resultBuilder.append(appendCharCount.c);
		}
	}
	return resultBuilder.toString();
    }
}

class CharCount {
	int count;
	char c;
	public CharCount(int count, char c) {
		this.count = count;
		this.c = c;
	}
}

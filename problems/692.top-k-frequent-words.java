/*
 * [692] Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (42.05%)
 * Total Accepted:    29.4K
 * Total Submissions: 69.7K
 * Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * ⁠   Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent
 * words,
 * ⁠   with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * 
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * 
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * 
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      List<String>[] bucket = new List[words.length + 1];
      Map<String, Integer> frequencyMap = new HashMap<String, Integer>();

      for (String word: words) {
	frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
      }

      for (String key: frequencyMap.keySet()) {
	int frequency = frequencyMap.get(key);
	if(bucket[frequency] == null) {
	  bucket[frequency] = new ArrayList<>();
	}
	bucket[frequency].add(key);
      }
      List<String> res = new ArrayList<>();
      for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
	if (bucket[pos] != null) {
	  Collections.sort(bucket[pos]);
	  for (int i = 0; i < bucket[pos].size() && res.size() < k; i++) {
	    res.add(bucket[pos].get(i));
	  }
	}
      }
      return res;
    }
}

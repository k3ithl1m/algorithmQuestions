/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (53.26%)
 * Total Accepted:    174.2K
 * Total Submissions: 327K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
	if (nums.length == 0) return new ArrayList<Integer>();
	if (nums.length == 1) {
		ArrayList<Integer> resultList = new ArrayList<>();
		resultList.add(nums[0]);
		return resultList;
	}
	HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
		freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
	}
//	TreeSet<Integer> freqSet = new TreeSet<Integer>(new Comparator<Integer>() {
//		@Override
//		public int compare(Integer a, Integer b) {
//			int valueA = freqMap.get(a);
//			int valueB = freqMap.get(b);
//			return (valueB>valueA) ?a:b;
//		}
//	});

	PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
		new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});

	for (Map.Entry<Integer, Integer> entrySet: freqMap.entrySet()) {
		maxHeap.add(entrySet);
	}
	
	ArrayList<Integer> resultList = new ArrayList<Integer>();
	for (int i = 0; i < k; i++) {
		resultList.add(maxHeap.poll().getKey());
	}
	return resultList;
    }
}



/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * algorithms
 * Medium (32.99%)
 * Total Accepted:    58.2K
 * Total Submissions: 176.4K
 * Testcase Example:  '[1,7,11]\n[2,4,6]\n3'
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]] 
 * Explanation: The first 3 pairs are returned from the sequence: 
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence: 
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * 
 */
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	ArrayList<int[]> resultList = new ArrayList<int[]>();
	if (nums1.length == 0 || nums2.length == 0 || k == 0) return resultList;
       	PriorityQueue<Pairs> pairHeap = new PriorityQueue<Pairs>( new Comparator<Pairs>() {
		public int compare(Pairs a, Pairs b) {
			return a.sum - b.sum;
		}
	}); 
	
	for (int i = 0; i < nums1.length; i++) {
		for (int j = 0; j < nums2.length; j++) {
			pairHeap.add(new Pairs(nums1[i], nums2[j]));
		}
	}

	int iterateLength = (k > pairHeap.size()) ? pairHeap.size() : k;
	for (int i = 0; i < iterateLength ; i++) {
		Pairs tempPair = pairHeap.poll();
		resultList.add(new int[]{tempPair.x, tempPair.y});	
	}

	return resultList;
    }
}

class Pairs {
	int x;
	int y;
	int sum;
	public Pairs(int x, int y) {
		this.x = x;
		this.y = y;
		this.sum = x + y;
	}
}

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 *
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 *
 * algorithms
 * Hard (28.58%)
 * Total Accepted:    16.9K
 * Total Submissions: 59K
 * Testcase Example:  '[1,3,1]\n1'
 *
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B. 
 * 
 * Example 1:
 * 
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0 
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * 
 * 
 * 
 * Note:
 * 
 * 2 .
 * 0 .
 * 1 .
 * 
 * 
 */
class Solution {

	//We can use binary search to find the k number i think
    public int smallestDistancePair(int[] nums, int k) {
	if (nums.length == 0) return 0;
	Arrays.sort(nums);
	int remainder = k % nums.length+1;
	boolean kLesser = false;
    }

	// TLE though!
	// we can save all the distance and put it into a priority queue and just pop
	// the ones out until we reach k (nlgn)
    public int smallestDistancePair2(int[] nums, int k) {
	if (nums.length == 0) return 0;
	PriorityQueue<Integer> distanceMap = new PriorityQueue<>();
	for (int i = 0; i < nums.length; i++) {
		for (int j = i+1; j < nums.length; j++) {
			int currentVal = Math.abs(nums[i] - nums[j]);
			distanceMap.offer(currentVal);
		}
	}

	for (int i = 0; i < k-1; i++) {
		distanceMap.poll();
	}
	return distanceMap.peek();
    }
}

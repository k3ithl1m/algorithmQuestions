/*
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (35.00%)
 * Total Accepted:    105.3K
 * Total Submissions: 299.6K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 */
class Solution {
	
    // We can do it in a way where we implement a heap 
    // and add the elements in. Whenever we add it in, 
    // but it will be o(nlgn)
    // lets try first`
    public int[] maxSlidingWindow(int[] nums, int k) {
	if (nums == null || nums.length == 0) return nums;
       	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
	ArrayList<Integer> ar = new ArrayList<Integer>();
	for (int i = 0; i< k; i++) {
		pq.add(nums[i]);
	} 
	
	ar.add(pq.peek());
	for (int i = 0; i < nums.length-k; i++) {
		pq.remove(nums[i]);
		pq.add(nums[i + k]);
		ar.add(pq.peek());
	}
	int[] res = new int[ar.size()]; 
	Iterator<Integer> iterator = ar.iterator();
	for (int i =0; i < ar.size(); i++) {
		res[i] = iterator.next().intValue();
	}
	return res; 
    }
}

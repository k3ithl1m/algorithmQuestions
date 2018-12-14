/*
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (40.03%)
 * Total Accepted:    176.7K
 * Total Submissions: 440.9K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
	if (nums == null || nums.length == 0) return 0;
	HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
	for (int i : nums) {
		Node n = new Node(i);
		n.parent = n;
		if (!hm.containsKey(i)) hm.put(i, n);
	}        
	
	int max = 1;
	for (int j: nums) {
		Node n = findUnion(j, j + 1, hm);
		if (n.rank > max) max = n.rank;
	}

	return max;
    }

    public Node findUnion(int left, int right, HashMap<Integer, Node> hm) {
	if (hm.containsKey(right) && hm.get(right).rank == 1) {
		Node n = hm.get(left);
		int count = n.rank;
		n.parent = hm.get(right);
		while(n.parent != n) {
			n = n.parent;
			n.rank = count;
			count++;
		}
		n.rank = count;
		return n;
	}
	return hm.get(left);
    }
}

class Node {
	int rank;
	int val;
	Node parent;
	Node(int val) {
		this.val = val;
		this.rank = 1;
	}
}

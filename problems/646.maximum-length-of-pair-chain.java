/*
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (47.55%)
 * Total Accepted:    25.2K
 * Total Submissions: 53.1K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
	if (pairs[0].length == 0) return 0;
	if (pairs[0].length == 1) return 1;
	Arrays.sort(pairs, new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	});
	int[] pairsCache = new int[pairs.length];
	int maxCount = 1, end = Integer.MIN_VALUE;
	for (int i = 0; i < pairs.length; i++) {
		recurse(pairs, i+1, pairs[i][1], pairsCache);
		maxCount = Math.max(pairsCache[i], maxCount);
	}	
	return maxCount;
    }

    private int recurse(int[][] pairs, int pos, int end, int[] cache) {
	if (pos >= pairs.length) return 1;
	if (cache[pos] > 0) return cache[pos];
	int maxCount = 1;
	for (int i = pos; i < pairs.length; i++) {
		if (pairs[i][0] > end) {
			maxCount = Math.max(maxCount, recurse(pairs, i+1, pairs[i][1], cache) + 1);
		}
	}
	cache[pos] = maxCount;
	return cache[pos];
    }

}

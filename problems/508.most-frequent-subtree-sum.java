/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (53.66%)
 * Total Accepted:    44.1K
 * Total Submissions: 82.1K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
	if (root == null) return new int[0];
	HashMap<Integer, Integer> sumAmountMap = new HashMap<Integer, Integer>();
	addSumToMapFindMax(root, sumAmountMap);
	ArrayList<Integer> sumResultList = new ArrayList<Integer>();
	int maxValue = 0;
	for (int key: sumAmountMap.keySet()) {
		maxValue = Math.max(sumAmountMap.get(key), maxValue);
	}	        
	for (int key: sumAmountMap.keySet()) {
		if (sumAmountMap.get(key) == maxValue) 
			sumResultList.add(key);
	}	        
	int[] result = new int[sumResultList.size()];
	for (int i = 0; i < result.length; i++) {
		result[i] = sumResultList.get(i);
	}
	return result;
    }

    private int addSumToMapFindMax(TreeNode root, HashMap<Integer, Integer> sumAmountMap) {
	if (root == null) return 0;
	int sum = root.val + addSumToMapFindMax(root.left, sumAmountMap) 
			+ addSumToMapFindMax(root.right, sumAmountMap);
	sumAmountMap.put(sum, sumAmountMap.getOrDefault(sum, 0) + 1);
//	int max = sumAmountMap.get(sum);
//	max = Math.max(max, Math.max(addSumToMapFindMax(root.left, sumAmountMap), addSumToMapFindMax(root.right, sumAmountMap)));
	return sum;
    }
}

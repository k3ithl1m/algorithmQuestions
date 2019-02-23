/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (57.90%)
 * Total Accepted:    70.3K
 * Total Submissions: 121.4K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * Example 1:
 * 
 * Input:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on
 * level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * 
 * 
 * Note:
 * 
 * The range of node's value is in the range of 32-bit signed integer.
 * 
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
    public List<Double> averageOfLevels(TreeNode root) {
	if (root == null) return new ArrayList<Double>();
	Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
	ArrayList<Double> levelsAverageList = new ArrayList<Double>();
	treeNodeQueue.offer(root);
	int treeNodeSize = treeNodeQueue.size();
	while (!treeNodeQueue.isEmpty()) {
		double total = 0;
		for (int i = 0; i < treeNodeSize; i++) {
			TreeNode currentNode = treeNodeQueue.poll();
			total += currentNode.val;
			if (currentNode.left != null) treeNodeQueue.offer(currentNode.left);
			if (currentNode.right != null) treeNodeQueue.offer(currentNode.right);
		}
		double average = total / treeNodeSize;
		levelsAverageList.add(average);
		treeNodeSize = treeNodeQueue.size();
	}        

	return levelsAverageList;
    }
}

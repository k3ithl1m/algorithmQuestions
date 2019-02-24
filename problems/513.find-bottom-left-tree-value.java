/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (57.83%)
 * Total Accepted:    64.9K
 * Total Submissions: 112.3K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * ⁠ Example 2: 
 * 
 * Input:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
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
    public int findBottomLeftValue(TreeNode root) {
	int leftmostVal = 0;
	Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
	treeNodeQueue.offer(root);
	int treeNodeQueueSize = treeNodeQueue.size();
	while(!treeNodeQueue.isEmpty()) {
		for (int i = 0; i < treeNodeQueueSize; i++) {
			TreeNode currentNode = treeNodeQueue.poll();
			if (i == 0) leftmostVal = currentNode.val;
			if (currentNode.left != null) treeNodeQueue.offer(currentNode.left);
			if (currentNode.right != null) treeNodeQueue.offer(currentNode.right);
		}
		treeNodeQueueSize = treeNodeQueue.size();
	}        
	return leftmostVal;
    }
}

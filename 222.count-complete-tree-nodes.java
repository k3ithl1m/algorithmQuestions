/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (30.96%)
 * Total Accepted:    105.6K
 * Total Submissions: 339.4K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
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
    public int countNodes(TreeNode root) {
	if (root == null) return 0;
	Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
	int maxCompleteTreeNodes = 0;
	treeNodeQueue.add(root);
	int levelSize = 1;
	int queueSize = treeNodeQueue.size();
	while (!treeNodeQueue.isEmpty()) {
		int countLevelSize = 0;
		for (int i = 0; i < queueSize; i++) {
			TreeNode currentNode = treeNodeQueue.remove();
			if (currentNode == null) break;	
			treeNodeQueue.add(currentNode.left);
			treeNodeQueue.add(currentNode.right);
			countLevelSize++;
		}
		if (levelSize == countLevelSize) {
			maxCompleteTreeNodes+= levelSize;
			levelSize *= 2;
			queueSize = treeNodeQueue.size();
		} else {
			maxCompleteTreeNodes += countLevelSize;
			break;
		}
	}        
	return maxCompleteTreeNodes;
    }
}

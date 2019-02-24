/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
 *
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 *
 * algorithms
 * Medium (46.84%)
 * Total Accepted:    23.8K
 * Total Submissions: 50.7K
 * Testcase Example:  '[4,2,6,3,1,5]\n1\n2'
 *
 * Given the root of a binary tree, then value v and depth d, you need to add a
 * row of nodes with value v at the given depth d. The root node is at depth
 * 1. 
 * 
 * The adding rule is: given a positive integer depth d, for each NOT null tree
 * nodes N in depth d-1, create two tree nodes with value v as N's left subtree
 * root and right subtree root. And N's original left subtree should be the
 * left subtree of the new left subtree root, its original right subtree should
 * be the right subtree of the new right subtree root. If depth d is 1 that
 * means there is no depth d-1 at all, then create a tree node with value v as
 * the new root of the whole original tree, and the original tree is the new
 * root's left subtree.
 * 
 * Example 1:
 * 
 * Input: 
 * A binary tree as following:
 * ⁠      4
 * ⁠    /   \
 * ⁠   2     6
 * ⁠  / \   / 
 * ⁠ 3   1 5   
 * 
 * v = 1
 * 
 * d = 2
 * 
 * Output: 
 * ⁠      4
 * ⁠     / \
 * ⁠    1   1
 * ⁠   /     \
 * ⁠  2       6
 * ⁠ / \     / 
 * ⁠3   1   5   
 * 
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * A binary tree as following:
 * ⁠     4
 * ⁠    /   
 * ⁠   2    
 * ⁠  / \   
 * ⁠ 3   1    
 * 
 * v = 1
 * 
 * d = 3
 * 
 * Output: 
 * ⁠     4
 * ⁠    /   
 * ⁠   2
 * ⁠  / \    
 * ⁠ 1   1
 * ⁠/     \  
 * 3       1
 * 
 * 
 * 
 * Note:
 * 
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
	if (root == null) {
		return new TreeNode(v);
	}        
	if (d == 1) {
		TreeNode newRoot = new TreeNode(v);
		newRoot.left = root;
		return newRoot;
	}
	Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
	treeNodeQueue.add(root);
	int queueSize = treeNodeQueue.size();
	int level = 1;
	while (!treeNodeQueue.isEmpty()) {
		for (int i = 0; i < queueSize; i++) {
			TreeNode currentNode = treeNodeQueue.remove();
			if (level < d-1) {
				if(currentNode.left != null) treeNodeQueue.add(currentNode.left);
				if(currentNode.right != null) treeNodeQueue.add(currentNode.right);
				
			}
			if (level == d-1) {
				if (currentNode.left != null) {
					TreeNode tempLeftNode = currentNode.left;
					currentNode.left = new TreeNode(v);
					currentNode.left.left = tempLeftNode;
				} else {
					currentNode.left = new TreeNode(v);
				}
				if (currentNode.right != null) {
					TreeNode tempRightNode = currentNode.right;
					currentNode.right = new TreeNode(v);
					currentNode.right.right = tempRightNode;
				} else {
					currentNode.right = new TreeNode(v);
				}
			}
		}

		level++;
		if (level == d) break;
		queueSize = treeNodeQueue.size();
	}
	return root;
	
    }
}

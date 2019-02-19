/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (50.00%)
 * Total Accepted:    301.4K
 * Total Submissions: 601.9K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
	ArrayList<Integer> resultList = new ArrayList<Integer>();
	if (root == null) return resultList;
	Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
	treeNodeStack.push(root);
	TreeNode currentNode;
	while(!treeNodeStack.isEmpty()) {
		currentNode = treeNodeStack.pop();
		resultList.add(currentNode.val);	
		if (currentNode.right != null) {
			treeNodeStack.push(currentNode.right);
		}
		if (currentNode.left != null) {
			treeNodeStack.push(currentNode.left);
		}
	}
	return resultList;        
    }

    private void traverse(TreeNode root, ArrayList<Integer> resultList) {
	if (root == null) return;
	resultList.add(root.val);
	traverse(root.left, resultList);
	traverse(root.right, resultList);
    }
}

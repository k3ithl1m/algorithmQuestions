/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (54.65%)
 * Total Accepted:    403.6K
 * Total Submissions: 736.8K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
	if (root == null) return new ArrayList<Integer>();        
	ArrayList<Integer> resultList = new ArrayList<>();
//	traverse(root, resultList);
	Stack<TreeNode> treeNodeStack = new Stack<>();
	Stack<TreeNode> leftNodeStack = new Stack<>();
	treeNodeStack.push(root);
	leftNodeStack.push(root);
	TreeNode prev = root;
	while(!treeNodeStack.isEmpty()) {
		TreeNode current = treeNodeStack.pop();
		if (current.left != null && leftNodeStack.peek() != current.left) {
			treeNodeStack.push(current);
			treeNodeStack.push(current.left);
			leftNodeStack.push(current.left);
		} else {
			resultList.add(current.val);
			if (current.left == leftNodeStack.peek()) leftNodeStack.pop();
			if (current.right != null) {
				treeNodeStack.push(current.right);
			}
		}
	}
	return resultList;
    }

    private void traverse(TreeNode root, ArrayList<Integer> resultList) {
	if (root == null) return;
	traverse(root.left, resultList);
	resultList.add(root.val);
	traverse(root.right, resultList);
    }
}

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (37.64%)
 * Total Accepted:    139.3K
 * Total Submissions: 369.2K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
	if (inorder.length == 0) return null;
	if (inorder.length == 1) return new TreeNode(inorder[0]);
	HashMap<Integer, TreeNode> treeNodeMap = new HashMap<>();
	int inorderPos = inorder.length - 1;
	TreeNode root = new TreeNode(postorder[postorder.length - 1]);
	TreeNode prev = root;
	boolean found = false;
	treeNodeMap.put(root.val, root);
	for (int i = postorder.length - 2; i >= 0; i--) {
		TreeNode currentNode = new TreeNode(postorder[i]);
		int postorderVal = postorder[i];
		int inorderVal = inorder[inorderPos];
		if (!found && !treeNodeMap.containsKey(inorder[inorderPos])) {
			if (postorderVal == inorderVal) found = true;
			prev.right = currentNode;
			prev = currentNode;
		} else {
			while (treeNodeMap.containsKey(inorder[inorderPos])) {
				inorderPos--;	
			};
			prev = treeNodeMap.get(inorder[inorderPos+1]);
			prev.left = currentNode;
			prev = currentNode;
			found = false;
		}
		treeNodeMap.put(currentNode.val, currentNode);
	}
	return root;
    }
}

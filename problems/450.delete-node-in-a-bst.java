/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (39.07%)
 * Total Accepted:    56.3K
 * Total Submissions: 143.8K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * 
 * 
 * Note: Time complexity should be O(height of tree).
 * 
 * Example:
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * 
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 * 
 * Another valid answer is [5,2,6,null,4,null,7].
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
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
	// if right is null, take left
	// if left is null, take right
	// if both is null, return
	//	if left and right are not null
	//	look into left of right. keep traversing down the left of right
	//	until both left and right of left of right == null;
    public TreeNode deleteNode(TreeNode root, int key) {
 	if (root == null) return root;
	if (root.val > key) {
		root.left = deleteNode(root.left, key);
	} else if (root.val < key) {
		root.right = deleteNode(root.right, key);
	}
	else {
		if (root.right == null && root.left == null) return null;
		else if (root.right == null) {
			return root.left;
		} else if (root.left == null) return root.right;
		TreeNode tempNode = findNode(root.right);
		root.val = tempNode.val;
		root.right = deleteNode(root.right, root.val);
	}
	return root;
    }

    private TreeNode findNode(TreeNode root) {
	while (root.left != null) {
		root = root.left;
	}
	return root;
    }
}

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (35.26%)
 * Total Accepted:    244.7K
 * Total Submissions: 693.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	TreeNode[] result = new TreeNode[1];
	findLCA(root, p, q, result);
	return result[0];        
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q, TreeNode[] result) {
	if (root == null) return false;
	boolean current = (root == p) || (root == q);
	boolean left = findLCA(root.left, p, q, result);
	boolean right = findLCA(root.right, p, q, result);
	if (left && right) result[0] = root;
	else if (current && left || current && right) result[0] = root;
	return current || left || right;
    }
}

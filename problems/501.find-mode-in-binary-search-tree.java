/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (38.58%)
 * Total Accepted:    48.2K
 * Total Submissions: 124.8K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
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
    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
	TreeMap<Integer, Integer> countMode = new TreeMap<Integer, Integer>();
	if (root == null) return new int[0];        
	helper(root, countMode);	
	ArrayList<Integer> result = new ArrayList<Integer>();
	for (int key: countMode.keySet()) {
		if (countMode.get(key) == max) {
			max = countMode.get(key);
			result.add(key);
		}
	}
	int[] resultInt = new int[result.size()];
	for (int i = 0; i < result.size(); i++) {
		resultInt[i] = result.get(i);
	}
	return resultInt;
    }

    public void helper(TreeNode root, TreeMap<Integer, Integer> countMode) {
	if (root == null) return;
	countMode.put(root.val, countMode.getOrDefault(root.val, 0) + 1);
	max = Math.max(countMode.get(root.val), max);
	helper(root.left, countMode);
	helper(root.right, countMode);
    }
}

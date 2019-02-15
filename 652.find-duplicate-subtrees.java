/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (43.74%)
 * Total Accepted:    31K
 * Total Submissions: 70.9K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
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

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		ArrayList<TreeNode> resultList = new ArrayList<TreeNode>();
		if (root == null) return resultList;
		HashMap<String, TreeNode> serializeNodeMap = new HashMap<>();
		traverse(first(root), serializeNodeMap);	
		for (TreeNode node: serializeNodeMap.values()) {
			if (node != null) resultList.add(node);
		}
		return resultList;
	}

	private void traverse(TreeNode root, HashMap<String, TreeNode> serializeNodeMap) {
		if (root == null) return;
		String serializedNode = serialize(root);
		if (serializeNodeMap.containsKey(serializedNode)) {
			serializeNodeMap.put(serializedNode, root);
		} else {
			serializeNodeMap.put(serializedNode, null);
		}
		traverse(root.left, serializeNodeMap);
		traverse(root.right, serializeNodeMap);
	}

	private TreeNode first(TreeNode root) {
		if (root == null) return null;
		if (root.left != null && root.right != null) return root; 
		if (root.left != null) return first(root.left);
		return first(root.right);
	}

	private String serialize(TreeNode root) {
		if (root == null) return "#";
		String s = String.valueOf(root.val);
		return s + "," + serialize(root.left) + "," + serialize(root.right);
	}

}

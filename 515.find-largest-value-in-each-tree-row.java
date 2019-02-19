/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (57.11%)
 * Total Accepted:    57.6K
 * Total Submissions: 100.9K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
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
    public List<Integer> largestValues(TreeNode root) {
	ArrayList<Integer> resultList = new ArrayList<Integer>();
	if (root == null) return resultList;
	Stack<TreeNodeLevel> treeNodeStack = new Stack<>();
	treeNodeStack.push(new TreeNodeLevel(root, 0));        
	while(!treeNodeStack.isEmpty()) {
		TreeNodeLevel currentTreeNode = treeNodeStack.pop();
		if (resultList.size() <= currentTreeNode.level) {
			resultList.add(currentTreeNode.root.val);
		} else if (resultList.get(currentTreeNode.level) < currentTreeNode.root.val) {
			resultList.set(currentTreeNode.level, currentTreeNode.root.val);
		}

		if (currentTreeNode.root.left != null) 
			treeNodeStack.push(new TreeNodeLevel(currentTreeNode.root.left, currentTreeNode.level + 1));
		if (currentTreeNode.root.right != null) 
			treeNodeStack.push(new TreeNodeLevel(currentTreeNode.root.right, currentTreeNode.level + 1));
	}
	return resultList;
    }
}

class TreeNodeLevel {
	TreeNode root;
	int level;
	public TreeNodeLevel(TreeNode root, int level) {
		this.root = root;
		this.level = level;
	} 
}

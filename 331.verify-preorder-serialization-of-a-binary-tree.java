/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 *
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (38.03%)
 * Total Accepted:    54.5K
 * Total Submissions: 143.1K
 * Testcase Example:  '"9,3,4,#,#,1,#,#,2,#,6,#,#"'
 *
 * One way to serialize a binary tree is to use pre-order traversal. When we
 * encounter a non-null node, we record the node's value. If it is a null node,
 * we record using a sentinel value such as #.
 * 
 * 
 * ⁠    _9_
 * ⁠   /   \
 * ⁠  3     2
 * ⁠ / \   / \
 * ⁠4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 
 * 
 * For example, the above binary tree can be serialized to the string
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * 
 * Given a string of comma separated values, verify whether it is a correct
 * preorder traversal serialization of a binary tree. Find an algorithm without
 * reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a
 * character '#' representing null pointer.
 * 
 * You may assume that the input format is always valid, for example it could
 * never contain two consecutive commas such as "1,,3".
 * 
 * Example 1:
 * 
 * 
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: "1,#"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "9,#,#,1"
 * Output: false
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
	if (preorder.length() == 0) return true;
	if (preorder.length() == 1) {
		if (preorder.charAt(0) == '#') return true;
		else return false;
	}        

	String elementArray = preorder.split(',');
	TreeNode root = new TreeNode(elementArray[0]);
	Stack<TreeNode> treeNodeStack = new Stack<>();
	treeNodeStack.push(root);
	for (int i = 0; i < elementArray.length; i++) {
		TreeNode currentNode = treeNodeStack.push
	}
	
    }
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	String element;
	public TreeNode(String element) {
		this.element = element;
	}
}

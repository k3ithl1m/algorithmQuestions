/*
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (45.55%)
 * Total Accepted:    219.7K
 * Total Submissions: 481.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
	LinkedList<Integer> ar = new LinkedList<Integer>();        
//	helper(root, ar);
	if (root == null) return ar;
	//iterative solution
	Stack<TreeNode> st = new Stack<TreeNode>();
	st.push(root);
	while(!st.isEmpty()) {
		TreeNode temp = st.pop();
		ar.addFirst(temp.val);
		if (temp.left != null) {
			st.push(temp.left);
		}
		if (temp.right != null) {
			st.push(temp.right);
		}
	} 
	return ar;
    }

    public void helper(TreeNode root, List<Integer> ar) {
	if (root == null) return;
	helper(root.left, ar);
	helper(root.right, ar);
	ar.add(root.val);
	return;
    }
}

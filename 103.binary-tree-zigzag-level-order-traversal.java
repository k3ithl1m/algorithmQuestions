/*
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (38.92%)
 * Total Accepted:    171.2K
 * Total Submissions: 439.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
	// have a treeContainerClass that could tell whether we should
	// go from left to right or right to left
	// do a breadth first search where the branches of the root
	// is entered into the queue based on the leftToRight boolean
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	if (root == null) return new ArrayList<List<Integer>>();
	Queue<TreeContainer> q = new LinkedList<TreeContainer>();
	Stack<TreeContainer> s = new Stack<TreeContainer>();
	q.add(new TreeContainer(root, true));
	boolean newLevel = true;
	ArrayList<Integer> ar = new ArrayList<Integer>();
	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	while(!q.isEmpty() || !s.isEmpty()) {
	    if (q.isEmpty() || s.isEmpty()) {
		result.add(ar);
		ar = new ArrayList<Integer>();
		newLevel = !newLevel;
	    }
	    TreeContainer tc = newLevel ? q.remove() : s.pop();
	    if (tc.root != null) { 
		    TreeNode temp = tc.root;
		    ar.add(tc.root.val);
		    if (tc.leftToRight) {
			s.push(new TreeContainer(temp.left, false));
			s.push(new TreeContainer(temp.right, false));
		    } else {
			q.add(new TreeContainer(temp.left, true));
			q.add(new TreeContainer(temp.right, true));
		    }
	    }
	}
	result.add(ar);
	return result; 
    }
}

class TreeContainer {
    TreeNode root;
    boolean leftToRight;
    TreeContainer(TreeNode root, boolean leftToRight) {
	this.root = root;
	this.leftToRight = leftToRight;
    }
}

/*
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (45.34%)
 * Total Accepted:    167.5K
 * Total Submissions: 369.5K
 * Testcase Example:  '[]'
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree. 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

	Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
	st = new Stack<TreeNode>();
	if (root != null) pushSmallest(root); 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return !st.empty(); 
    }

    /** @return the next smallest number */
    public int next() {	
       	TreeNode temp = st.pop();
	pushSmallest(temp.right);
	return temp.val; 
    }

	public void pushSmallest(TreeNode root) {
		while(root != null) {
			st.push(root);
			root = root.left;
		}	
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

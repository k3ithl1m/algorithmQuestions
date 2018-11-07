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
	Stack<TreeContainer> s1 = new Stack<TreeContainer>();
	Stack<TreeContainer> s2 = new Stack<TreeContainer>();
	s1.push(new TreeContainer(root, true));
	boolean newLevel = true;
	ArrayList<Integer> ar = new ArrayList<Integer>();
	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	while(!s1.isEmpty() || !s2.isEmpty()) {
	    TreeContainer tc = newLevel ? s1.pop() : s2.pop();
	    if (tc.root != null) { 
		    TreeNode temp = tc.root;
		    ar.add(tc.root.val);
		    if (!tc.leftToRight) {
			if (temp.right != null) s1.push(new TreeContainer(temp.right, true));
			if (temp.left != null) s1.push(new TreeContainer(temp.left, true));
		    } else {
			if (temp.left != null) s2.push(new TreeContainer(temp.left, false));
			if (temp.right != null) s2.push(new TreeContainer(temp.right, false));
		    }
	    }
	    if ((newLevel && s1.isEmpty()) || (!newLevel && s2.isEmpty())) {
		result.add(ar);
		ar = new ArrayList<Integer>();
		newLevel = !newLevel;
	    }
	}
	return result; 
    }

    //this is actually f$cking ingenius
    public void traverse(TreeNode root, List<List<Integer>> res, int depth)
    {
        if (root == null) return;
        
        if (res.size() <= depth)
            res.add(new ArrayList<>());
        
        List<Integer> lst = res.get(depth);
        
        if (depth % 2 == 0) lst.add(root.val);
        else lst.add(0, root.val);
            
        traverse(root.left,  res, depth + 1);
        traverse(root.right, res, depth + 1);
        
    }
    
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
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

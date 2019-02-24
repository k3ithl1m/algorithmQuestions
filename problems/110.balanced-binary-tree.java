/*
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (39.54%)
 * Total Accepted:    267K
 * Total Submissions: 675.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * 
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 * 
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * Return false.
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
    // have a min and a max, whenever it reaches null, update the value
    // get the difference of the min and max value, if it is more than one
    // then return false.
    // - helper {
    // TreeNode root,
    // int val(min/max)
    // boolean isMax
    // int depth
    // }
    //
    // if isMax is true, then when we reach null. we'll compare it and make sure 
    // max is max.
    // helper {
    // 	if null {
    // 		if isMax return Math.max(depth, val);
    // 		else return Math.min(depth, val);
    // 	}
    // 	depth++;
    // 	if (isMax) return Math.max(helper(root.left, val, isMax, depth), 
    // 					helper(root.right, val, isMax, depth));
    // 	else return Math.min(helper(root.left, val, isMax, depth), 
    // 					helper(root.right, val, isMax, depth));
    // }
    //
    // solution {
    // max = Math.max(helper(root.left, Integer.MIN_VALUE, true, 0), 
    // 			helper(root.right, Integer.MIN_VALUE, true, 0);
    // min = Math.min(helper(root.left, Integer.MAX_VALUE, false, 0), 
    // 			helper(root.right, Integer.MAX_VALUE, false, 0);
    //
    // return (max - min <= 1);
    // }

    public boolean isBalanced(TreeNode root) {
	if (root == null) return true;	
//	int max = Math.max(helper(root.left, Integer.MIN_VALUE, true, 0),
//			helper(root.right, Integer.MIN_VALUE, true, 0));
//	int min = Math.min(helper(root.left, Integer.MAX_VALUE, false, 0),
//			helper(root.right, Integer.MAX_VALUE, false, 0));
//	System.out.println("min = " + min);
//	System.out.println("max = " + max);
//	return (max-min <= 1);
	return height(root) != -1;
    }

    public int helper(TreeNode root, int val, boolean isMax, int depth) {
	if (root == null) {
		if (isMax) return Math.max(depth, val);
		else return Math.min(depth, val);
	}
	depth++;
	if (isMax) return Math.max(helper(root.left, val, isMax, depth), 
			helper(root.right, val, isMax, depth));
	else return Math.min(helper(root.left, val, isMax, depth),
			helper(root.right, val, isMax, depth));

    }

    public int height(TreeNode node) {
	    if (node ==null) return 0;
	    int lh = height(node.left);
	    if (lh == -1) return -1;
	    int rh = height(node.right);
	    if (rh == -1) return -1;
	    if (lh-rh < -1 || lh - rh > 1) return -1;
	    return Math.max(lh, rh)+1;
    }
}

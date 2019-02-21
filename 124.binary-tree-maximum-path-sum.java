/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (29.14%)
 * Total Accepted:    171K
 * Total Submissions: 585.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
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
	//a path means that its only a straight line. So only
	//one of the root can use both left and right, all the others
	//can only have left or right or not use left or right at all

	//I think we can solve it in O(n2), we just need to treat
	// every node as a potential break up point.
	// the root will have maxTraverse(root.left) + root.val + maxTraverse(root.right);
	// 	maxTraverse will choose Math.max(root.val, 
	//		Math.max(maxTraverse(root.left), maxTraverse(root.right)) + root.val, 0)
	// 	so it chooses between, just the root itself, root plus max of left and right, or no root 
	// at all

    public int maxPathSum2(TreeNode root) {
       	if (root == null) return 0;
	if (root.left == null && root.right == null) return root.val;
	int maxLeft = maxTraverse(root.left);
	int maxRight = maxTraverse(root.right);
	int max = root.val;
	max = Math.max(max, Math.max(max + maxLeft, Math.max(max + maxRight, max + maxRight + maxLeft)));
	if (root.left != null) max = Math.max(max, maxPathSum(root.left)); 
	if (root.right != null) max = Math.max(max, maxPathSum(root.right)); 
	return max;
    }

    private int maxTraverse(TreeNode root) {
	if (root == null) return 0;
	int max = Math.max(root.val, Math.max(maxTraverse(root.left), maxTraverse(root.right)) + root.val);
	return max;
    }

	




	public int maxPathSum(TreeNode root) {
		int[] storeMax = new int[]{Integer.MIN_VALUE};
		findMax(root, storeMax);
		return storeMax[0];
	}

	private int findMax(TreeNode root, int[] storeMax) {
		if (root == null) return 0;
		int left = Math.max(findMax(root.left, storeMax), 0);
		int right = Math.max(findMax(root.right, storeMax), 0);
		storeMax[0] = Math.max(storeMax[0], root.val + left + right);
		return root.val + Math.max(left, right);
	}
}

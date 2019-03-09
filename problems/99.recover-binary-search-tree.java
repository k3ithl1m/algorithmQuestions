/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (33.69%)
 * Total Accepted:    110.1K
 * Total Submissions: 326.4K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
	// we first need to be able to find whether the node is in the right spot
	// to do that, we just need to check if it's in the right spot.
	// When we found one problem node, we grab it and put it in a store,
	// we either go up or down to see whether it will fit the range
    public void recoverTree(TreeNode root) {
 	if (root == null || (root.left == null && root.right == null)) return;       
	int[] storeVal = int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
	checkTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE, storeVal);
    }

    private void checkTree(TreeNode root, int leftBound, int rightBound, int[] storeVal) {
	if (root == null) return;
	if (storeVal[0] != Integer.MIN_VALUE && storeVal[0] > leftBound && storeVal[0] < rightBound) {
		storeVal[1] = root.val;
		root.val = storeVal[0];
	}

	if (root.val != :wq

	checkTree(root.left, leftBound, root.val, storeVal);
	checkTree(root.right, root.val, rightBound, storeVal);
    }
}

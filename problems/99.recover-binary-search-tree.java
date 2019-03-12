/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (33.87%)
 * Total Accepted:    111.6K
 * Total Submissions: 329K
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
    public void recoverTree(TreeNode root) {       
	TreeNode[] nodeStore = new TreeNode[3];
	nodeStore[2] = new TreeNode(Integer.MIN_VALUE);
	traverse(root, nodeStore);
	int temp = nodeStore[0].val;
	nodeStore[0].val = nodeStore[1].val;
	nodeStore[1].val = temp;
    }

    private void traverse(TreeNode root, TreeNode[] nodeStore) {
	if (root == null) return;
	traverse(root.left, nodeStore);
	checkNode(root, nodeStore);
	nodeStore[2] = root;
	traverse(root.right, nodeStore);
    }

    private void checkNode(TreeNode root, TreeNode[] nodeStore) {
	if (nodeStore[0] == null && nodeStore[2].val >= root.val) {
		nodeStore[0] = nodeStore[2];
	}
	if (nodeStore[0] != null && nodeStore[2].val >= root.val) {
		nodeStore[1] = root;
	}
    }
}

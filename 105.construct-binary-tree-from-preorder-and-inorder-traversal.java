/*
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (37.46%)
 * Total Accepted:    176.3K
 * Total Submissions: 470.3K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    // Using example {10, 12, 3, 4, 6, 7, 5, 11, 2, 8}
    // and  {3, 12, 6, 4, 7, 10, 11, 5, 2, 8}
    // Create a hashmap<Integer, TreeNode>
    // - go through pre order, and fill up root, then root.left.
    // until the number of preorder is similar to first number in inorder. 
    // F.E at 3
    // - add it to Hashmap every time we add a new root.
    // - go through in order until we find a number that is 
    // not in the hashmap
    // - we then take the number (inorderPos - 1) to get the root that
    // we have to populate root.right with.
    // - using the number, pull the root from the hashmap and 
    // start working with that root.
    // - populate right, but then populate left with preorder
    // until it hits the same number. 
    // - repeat. until end. 
    // - ##IMportant, if the preOrderPos is at the end, then add it to the right. 
    // - return HashMap.get(preOrder[0]);
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	if (preorder.length == 0 || preorder == null) return null;
	if (preorder.length == 1) return new TreeNode(preorder[0]);
        HashMap<Integer, TreeNode> hm = new HashMap<Integer, TreeNode>();
	int inorderPos =0;
	boolean found = false;
	TreeNode root = new TreeNode(0);
	TreeNode next;
        for (int i = 0; i < preorder.length; i++) {
		int currentVal = preorder[i];
		next = new TreeNode(currentVal);
		if (found) {
			found = false;	
			root.right = next;
		} else if (root != null) {
			root.left = next;
		}
		root = next;
		hm.put(currentVal, next);
		if (currentVal == inorder[inorderPos] && i < preorder.length) {
			found = true;
			while( inorderPos < inorder.length -1 && hm.containsKey(inorder[inorderPos])) {
				inorderPos++;
			}
			System.out.println(inorder[inorderPos]);
			root = hm.get(inorder[inorderPos - 1]);
		}
	}
	return hm.get(preorder[0]);
    }
}

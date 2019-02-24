/*
 * [662] Maximum Width of Binary Tree
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (38.45%)
 * Total Accepted:    18.7K
 * Total Submissions: 48.6K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given a binary tree, write a function to get the maximum width of the given
 * tree. The width of a tree is the maximum width among all levels. The binary
 * tree has the same structure as a full binary tree, but some nodes are
 * null. 
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 * 
 * Example 1:
 * 
 * Input: 
 * 
 * ⁠          1
 * ⁠        /   \
 * ⁠       3     2
 * ⁠      / \     \  
 * ⁠     5   3     9 
 * 
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4
 * (5,3,null,9).
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        /  
 * ⁠       3    
 * ⁠      / \       
 * ⁠     5   3     
 * 
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2
 * (5,3).
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2 
 * ⁠      /        
 * ⁠     5      
 * 
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length
 * 2 (3,2).
 * 
 * 
 * Example 4:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /     \  
 * ⁠     5       9 
 * ⁠    /         \
 * ⁠   6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8
 * (6,null,null,null,null,null,null,7).
 * 
 * 
 * 
 * 
 * Note:
 * Answer will in the range of 32-bit signed integer.
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
    public int widthOfBinaryTree(TreeNode root) {
	if (root == null) return 0;
	int maxLength = 0;
	Queue<TreeNodePos> treeNodeQueue = new LinkedList<TreeNodePos>();
	treeNodeQueue.add(new TreeNodePos(root, 1));
	int queueSize=treeNodeQueue.size();
	while(!treeNodeQueue.isEmpty()) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < queueSize; i++) {
			TreeNodePos currentNode = treeNodeQueue.remove();
			min = Math.min(min, currentNode.pos);
			max = Math.max(max, currentNode.pos);
			if (currentNode.root.left != null) 
				treeNodeQueue.add(new TreeNodePos(currentNode.root.left, currentNode.pos * 2 -1));
			if (currentNode.root.right != null) 
				treeNodeQueue.add(new TreeNodePos(currentNode.root.right, currentNode.pos * 2 ));
		}
		maxLength = Math.max(maxLength, max-min + 1);
		queueSize = treeNodeQueue.size();
	}              
	return maxLength;
    }
}

class TreeNodePos {
	TreeNode root;
	int pos;
	public TreeNodePos(TreeNode root, int pos) {
		this.root = root;
		this.pos = pos;
	}
}

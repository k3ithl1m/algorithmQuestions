/*
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (43.99%)
 * Total Accepted:    198.8K
 * Total Submissions: 450K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
	ArrayList<String> res = new ArrayList<String>();
	if (root == null) return res;
	ArrayList<Integer> count = new ArrayList<Integer>();
	helper(root, res, count);	
	return res;        
    }

   public void helper(TreeNode root, List<String> res, List<Integer> count) {
	if (root == null) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count.size(); i++) {
			sb.append(count.get(i));
			if (i < count.size() -1) sb.append("->");	
		}
		String s = sb.toString();
		if (!res.contains(s)) res.add(s);
	} else {
		count.add(root.val);
		if (root.left == null && root.right !=null) helper(root.right, res, count);
		else if (root.right == null && root.left != null) helper(root.left, res, count);
		else {
			helper(root.left, res, count);
			helper(root.right, res, count);
		}
		count.remove(count.size() -1);
	}
	
   }
}

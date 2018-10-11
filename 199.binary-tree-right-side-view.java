/*
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (43.89%)
 * Total Accepted:    125.1K
 * Total Submissions: 282.7K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
	// We need a hash map to keep track of every right element
	// 
    public List<Integer> rightSideView(TreeNode root) {
	HashMap<Integer, Integer> hm =  new HashMap<Integer, Integer>();
	Queue<TreeNode> tnodeQ = new LinkedList<TreeNode>();
	Queue<Integer> depthQ = new LinkedList<Integer>();

	tnodeQ.add(root);
	depthQ.add(0);

	while(!tnodeQ.isEmpty()) {
	  TreeNode n =  tnodeQ.poll();
	  int depth = depthQ.poll();
	  if (n == null) continue;
	  if (!hm.containsKey(depth)) {
	    hm.put(depth, n.val);
	  }
	  tnodeQ.add(n.right);
	  depthQ.add(depth + 1);
	  tnodeQ.add(n.left);
	  depthQ.add(depth + 1);
	}	

	ArrayList<Integer> list = new ArrayList<Integer>();
	for (int key: hm.keySet()) {
	  list.add(hm.get(key));
	}
	return list;
    }
}

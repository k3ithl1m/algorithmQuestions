/*
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (37.99%)
 * Total Accepted:    193.9K
 * Total Submissions: 510.3K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    // We traverse down the tree with a list, adding values
    // to the list as we go.
    // - When we reach the end of a child (when root == null)
    // we check if the sum is equal. If it is, then we add to
    // the list of list. 
    // - as we go back to the previous branch, we have to remove 
    // the value from the list and the sum
    //
    // solution {
    // 	List ar;
    // 	List<List> bigAr;
    // 	helper (root, sum, 0, ar, bigAr);
    // 	return bigAr;
    // 	}
    //
    // 	helper (root, sum, total, ar, bigAr) {
    // 	  if (null) if (total == sum) {
    // 	      if (!bigAr.contains(ar)) bigAr.add(new ar with all the valus); 
    // 	      return;
    // 	  }
    // 	  ar.add(root.val);
    // 	  helper(root.left, sum, total + root.val, ar, bigAr);
    // 	  helper(root.right, sum, total + root.val, ar, bigAr);
    //    ar.remove(ar.size()-1);
    //    return;
    //  }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       ArrayList<Integer> ar = new ArrayList<Integer>();
       ArrayList<List<Integer>> bigAr = new ArrayList<List<Integer>>();
       if (root == null) return bigAr;
       helper(root, sum, 0, ar, bigAr);
       return bigAr;
    }

    public void helper(TreeNode root, int sum, int total, List<Integer> ar, List<List<Integer>> bigAr) {
	if (root == null) return;
	if ((root.left == null && root.right ==null )) {
	    if (total +root.val == sum) {
		ar.add(root.val);
		bigAr.add(new ArrayList<Integer>(ar));	
		ar.remove(ar.size() - 1);
	    }
	    return;
	}
	ar.add(root.val);
	helper(root.left, sum, total + root.val, ar, bigAr);
	helper(root.right, sum, total + root.val, ar, bigAr);
	ar.remove(ar.size() - 1);
	return;
    }
}

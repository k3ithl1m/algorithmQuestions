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
    public boolean findTarget(TreeNode root, int k) {
	if (root == null) return false;
	HashSet<Integer> existedIntegerSet = new HashSet<Integer>();
	return findExist(root, k, existedIntegerSet);
    }
    
    private boolean findExist(TreeNode root, int k, HashSet<Integer> existedIntegerSet) {
	if (root == null) return false;
	if (existedIntegerSet.contains(k-root.val)) return true;
	existedIntegerSet.add(root.val);
	return findExist(root.left,k, existedIntegerSet) || findExist(root.right,k, existedIntegerSet);
    }
}

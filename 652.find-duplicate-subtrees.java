/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (43.74%)
 * Total Accepted:    31K
 * Total Submissions: 70.9K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	if (root == null) return new ArrayList<TreeNode>();
	HashMap<Integer, ArrayList<TreeNode>> valToArrayOfTreeNodeMap = 
			new HashMap<Integer, ArrayList<TreeNode>>();

	fillMapWithNodes(root, valToArrayOfTreeNodeMap);
	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
	for (int key : valToArrayOfTreeNodeMap.keySet()) {
		ArrayList<TreeNode> tempArray = valToArrayOfTreeNodeMap.get(key);
		for (int i = 0; i < tempArray.size(); i++) {
			for (int j = i + 1; j < tempArray.size(); j++) {
				if (!result.contains(tempArray.get(i)) && 
					checkEqual(tempArray.get(i), tempArray.get(j))) 
				{
					for (int k = 0; k < result.size(); k++) {
						if (checkEqual(result.get(k), tempArray.get(i))) {
							result.add(tempArray.get(i));
						}
					}
				}
			}
		}
	} 

	return result;
    }

    private void fillMapWithNodes(TreeNode root, HashMap<Integer, ArrayList<TreeNode>> map) {
	if (root == null) return;
	ArrayList<TreeNode> treeNodeArray = map.get(root.val);
	if (treeNodeArray == null) {
		treeNodeArray = new ArrayList<TreeNode>();
		treeNodeArray.add(root);
		map.put(root.val, treeNodeArray);
	} else treeNodeArray.add(root);
	fillMapWithNodes(root.left, map);
	fillMapWithNodes(root.right, map);
    }

    private boolean checkEqual(TreeNode left, TreeNode right) {
	if (left == null && right == null) return true;
	if (left == null || right == null) return false;
	return left.val == right.val && checkEqual(left.left, right.left) && checkEqual(left.right, right.right);
    }
}
